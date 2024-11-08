package com.conurets.parking_kiosk.mapper;

import com.conurets.parking_kiosk.base.dto.request.UserRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.RoleResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.UserResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.PKConstants;
import com.conurets.parking_kiosk.persistence.entity.Role;
import com.conurets.parking_kiosk.persistence.entity.User;
import com.conurets.parking_kiosk.persistence.entity.UserLogin;
import com.conurets.parking_kiosk.persistence.entity.UserRole;
import com.conurets.parking_kiosk.security.util.PKSecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.conurets.parking_kiosk.base.util.PKConstants.Common.*;

/**
 * @author Adeel Ali & Zohaib Ahmed
 * @version 1.0
 */

@Component
public class UserMapper extends BaseMapper{

    @Autowired
    UserRoleMapper userRoleMapper;

    public User add(UserRequestDTO model) throws PKException{
        User user = new User();
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmailAddress(model.getEmailAddress());
        user.setMobilePhone(model.getMobilePhone());
        user.setStatus(model.getStatus());
        user.setAlternateEmailAddress(model.getAlternateEmailAddress());
        addAuditingInformation(user);
        return user;
    }

    public User update(UserRequestDTO model,Long id) throws PKException{
        User user = userRepository.findById(id).get();
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmailAddress(model.getEmailAddress());
        user.setMobilePhone(model.getMobilePhone());
        user.setStatus(model.getStatus());
        user.setAlternateEmailAddress(model.getAlternateEmailAddress());
        user.setLastUpdate(model.getLastUpdate());
        user.setLastUpdateBy(model.getLastUpdateBy());
        return user;
    }

    public User activeUser(User user) throws PKException{
        user.setStatus(STATUS_CODE_ACTIVE);
        addAuditingInformation(user);
        return user;
    }

    public User deActivateUser(User user) throws PKException{
        user.setStatus(STATUS_CODE_INACTIVE);
        addAuditingInformation(user);
        return user;
    }

    public User deleteUser(User user) throws PKException{
        user.setStatus(PKConstants.Common.STATUS_CODE_DELETE);
        addAuditingInformation(user);
        return user;
    }

    public UserLogin addUserLogin(UserRequestDTO model, User user) throws PKException{
        UserLogin userLogin = new UserLogin();
        userLogin.setUser(user);
        userLogin.setCredential(PKSecurityUtil.generatePassword(model.getPassword()));
        userLogin.setStatus(model.getStatus());
        addAuditingInformation(userLogin);
        return userLogin;
    }

    public UserLogin updateUserLogin(UserLogin user) throws PKException{
        user.setStatus(STATUS_CODE_ACTIVE);
        addAuditingInformation(user);
        return user;
    }

    public UserLogin deActivateUserLogin(UserLogin user) throws PKException{
        user.setStatus(STATUS_CODE_INACTIVE);
        addAuditingInformation(user);
        return user;
    }

    public UserLogin deleteUserLogin(UserLogin user) throws PKException{
        user.setStatus(STATUS_CODE_DELETE);
        addAuditingInformation(user);
        return user;
    }

    public UserResponseDTO find(User user) throws PKException {
        UserResponseDTO userDTO = new UserResponseDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmailAddress(user.getEmailAddress());
        userDTO.setMobilePhone(user.getMobilePhone());
        userDTO.setAlternateEmailAddress(user.getAlternateEmailAddress());
        userDTO.setStatus(user.getStatus());

        Optional<UserRole> role = roleRepository.findByUserId(user.getId());
        userDTO.setRole(userRoleMapper.find(role.get().getRole()));

        return userDTO;
    }

    public UserResponseDTO find(UserRole user) throws PKException {
        UserResponseDTO userDTO = new UserResponseDTO();
        userDTO.setId(user.getUser().getId());
        userDTO.setFirstName(user.getUser().getFirstName());
        userDTO.setLastName(user.getUser().getLastName());
        userDTO.setEmailAddress(user.getUser().getEmailAddress());
        userDTO.setAlternateEmailAddress(user.getUser().getAlternateEmailAddress());
        userDTO.setMobilePhone(user.getUser().getMobilePhone());
        userDTO.setStatus(user.getUser().getStatus());

        Optional<UserRole> role = roleRepository.findByUserId(user.getUser().getId());
        userDTO.setRole(userRoleMapper.find(role.get().getRole()));

        return userDTO;
    }
}
