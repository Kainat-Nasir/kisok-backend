package com.conurets.parking_kiosk.service.Impl;

import com.conurets.parking_kiosk.base.dto.request.UserRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.UserResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.*;
import com.conurets.parking_kiosk.mapper.UserMapper;
import com.conurets.parking_kiosk.mapper.UserRoleMapper;
import com.conurets.parking_kiosk.persistence.entity.Role;
import com.conurets.parking_kiosk.persistence.entity.User;
import com.conurets.parking_kiosk.persistence.entity.UserLogin;
import com.conurets.parking_kiosk.persistence.entity.UserRole;
import com.conurets.parking_kiosk.persistence.repository.RoleRepository;
import com.conurets.parking_kiosk.persistence.repository.UserLoginRepository;
import com.conurets.parking_kiosk.persistence.repository.UserRepository;
import com.conurets.parking_kiosk.persistence.repository.UserRoleRepository;
import com.conurets.parking_kiosk.security.util.PKSecurityUtil;
import com.conurets.parking_kiosk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    UserRepository userRepository;
    UserLoginRepository userLoginRepository;
    RoleRepository roleRepository;
    UserRoleRepository userRoleRepository;
    UserMapper userMapper;
    UserRoleMapper userRoleMapper;

    //Constructor
    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserLoginRepository userLoginRepository, RoleRepository roleRepository, UserRoleRepository userRoleRepository, UserMapper userMapper, UserRoleMapper userRoleMapper) {
        this.userRepository = userRepository;
        this.userLoginRepository = userLoginRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
        this.userMapper = userMapper;
        this.userRoleMapper = userRoleMapper;
    }

    private void Validations(UserRequestDTO model,String operation){
        if(!PKSecurityUtil.validateEmail(model.getEmailAddress())){
            throw new PKException("Invalid Email Address");
        }
        model.setPassword(model.getPassword() == null ? "test" : "");
        if(operation.equals("add")){
            getPkValidationUtil().validateEmailAddress(model.getEmailAddress());
        }

        if (!PKSecurityUtil.getUserRole().equals(PKConstants.SuperAdmin.SUPER_ADMIN_ROLE) && model.getRoleId() == 1) {
            throw new PKException("You are not allowed to select this role");
        }
    }

    private void SettingUserCredentialsAndRole(UserRequestDTO model, User user){
        UserLogin userLogin= userMapper.addUserLogin(model,user);
        userLoginRepository.save(userLogin);
        Optional<Role> role = roleRepository.findById(model.getRoleId());
        if(role.isPresent()){
            UserRole userRole = userRoleMapper.add(role.get(),user);
            userRoleRepository.save(userRole);
        }
    }

    public void registerUser(UserRequestDTO model) throws PKException {
        Optional<User> existingUser = userRepository.findByEmailAddress(model.getEmailAddress());

        if(existingUser.isPresent()){
            PKHelper.handleResultNotFound(PKStatusConstants.STATUS_CODE_RECORD_ALREADY_EXISTS, PKStatusConstants.STATUS_MSG_RECORD_ALREADY_EXISTS);
        }

        String subject ="Welcome! Your New Account Has Been Created";
        String password = UUID.randomUUID().toString();
        User user = userMapper.add(model);
        userRepository.save(user);
        //UserResponseDTO userResponseDTO= userMapper.userEntityToUserResponseDTO(userRepository.save(user));
        model.setPassword("test");
        SettingUserCredentialsAndRole(model,user);
//        userResponseDTO.setRole(roleMapper.find(role.get()));
//        PEEmailUtil.sendEmail(model.getEmailAddress(), subject, PEConstants.USER_CREATED_EMAIL+password);
//        return userResponseDTO ;
    }

    @Transactional
    public UserResponseDTO addUser(UserRequestDTO model) throws PKException {
        Validations(model,"add");
        UserResponseDTO userDTO = null;
        User user = userMapper.add(model);
        userRepository.save(user);
        SettingUserCredentialsAndRole(model,user);
        userDTO = userMapper.find(user);
        return userDTO;
    }

    @Transactional
    public UserResponseDTO updateUser(UserRequestDTO model,Long Id) throws PKException {
        Validations(model,"update");

        UserResponseDTO userDTO;
        User user = userMapper.update(model,Id);
        userRepository.save(user);

        Optional<Role> role = roleRepository.findById(model.getRoleId());
        if(role.isPresent()){
            UserRole userRole = userRoleMapper.update(role.get(),user,model.getStatus());
            userRoleRepository.save(userRole);
        }
        userDTO = userMapper.find(user);
        return userDTO;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() throws PKException {
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        List<User> users;
        List <UserRole> userRoles = userRoleRepository.findAll();
        if(PKConstants.SuperAdmin.SUPER_ADMIN_ROLE.equals(PKSecurityUtil.getUserRole())){
            if(PKUtil.isCollectionNotBlank(userRoles)){
                userResponseDTOList = userRoles.stream()
                        .map(user -> {
                            UserResponseDTO userResponseDTO = userMapper.find(user);
                            return userResponseDTO;
                        }).collect(Collectors.toList());
            }
        }else{
//            users = userRepository.findUsersByStatusEqualsOne();
            users = userRepository.findAll();
            if (PKUtil.isCollectionNotBlank(users)) {
                userResponseDTOList = users.stream()
                        .map(user -> userMapper.find(user))
                        .collect(Collectors.toList());
            }
        }
        return userResponseDTOList;
    }

    @Override
    @Transactional
    public UserResponseDTO findUserById(Long userId) throws PKException {
        UserResponseDTO userDTO = new UserResponseDTO();
        Optional<User> unique_User= userRepository.findById(userId);
        if (unique_User.isEmpty()) {
            return userDTO;
        }
        userDTO = userMapper.find(unique_User.get());
        return userDTO;
    }

    private UserResponseDTO updateUserStatus(Long userId,
                                             Function<User, User> userStatusMapper,
                                             Function<UserLogin, UserLogin> userLoginMapper) throws PKException {
        UserResponseDTO userDTO = new UserResponseDTO();

        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            return userDTO;
        }

        User user = userStatusMapper.apply(userOptional.get());
        userRepository.save(user);

        Optional<UserLogin> userCredential = userLoginRepository.findByUserId(userId);
        if (userCredential.isPresent()) {
            UserLogin userLogin = userLoginMapper.apply(userCredential.get());
            userLoginRepository.save(userLogin);
        }

        userDTO = userMapper.find(user);
        return userDTO;
    }

    @Override
    @Transactional
    public UserResponseDTO activeUser(Long userId) throws PKException {
        return updateUserStatus(userId, userMapper::activeUser, userMapper::updateUserLogin);
    }

    @Override
    @Transactional
    public UserResponseDTO deActivateUser(Long userId) throws PKException {
        return updateUserStatus(userId, userMapper::deActivateUser, userMapper::deleteUserLogin);
    }


    @Override
    @Transactional
    public void deleteUser(Long userId) throws PKException {
        User active_User= userRepository.findById(userId).get();
        if (active_User == null) {
        }
        active_User = userMapper.deleteUser(active_User);
        userRepository.save(active_User);

        Optional <UserLogin> userCredential = userLoginRepository.findByUserId(userId);
        if(userCredential.isPresent()){
            UserLogin userLogin =  userMapper.deActivateUserLogin(userCredential.get());
            userLoginRepository.save(userLogin);
        }
    }
}
