package com.conurets.parking_kiosk.service.Impl;

import com.conurets.parking_kiosk.base.dto.request.UserPropertyRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.UserPropertyResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.PKConstants;
import com.conurets.parking_kiosk.base.util.PKUtil;
import com.conurets.parking_kiosk.mapper.UserMapper;
import com.conurets.parking_kiosk.mapper.UserPropertyMapper;
import com.conurets.parking_kiosk.persistence.entity.UserProperty;
import com.conurets.parking_kiosk.persistence.repository.UserPropertyRepository;
import com.conurets.parking_kiosk.service.UserPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserPropertyServiceImpl extends BaseServiceImpl implements UserPropertyService {
    UserPropertyMapper userPropertyMapper;
    UserPropertyRepository userPropertyRepository;

    @Autowired
    public UserPropertyServiceImpl(UserPropertyMapper userPropertyMapper, UserPropertyRepository userPropertyRepositery) {
        this.userPropertyMapper = userPropertyMapper;
        this.userPropertyRepository=userPropertyRepositery;
    }

    public UserPropertyResponseDTO add(UserPropertyRequestDTO userPropertyRequestDto) throws PKException {
        UserProperty userProperty= userPropertyMapper.addUserProperty(userPropertyRequestDto);
        userPropertyRepository.save(userProperty);
        return userPropertyMapper.find(userProperty);
    }
    public UserPropertyResponseDTO update(UserPropertyRequestDTO userPropertyRequestDto, Long Id) throws PKException {
        Optional<UserProperty> newUserProperty = userPropertyRepository.findById(Id);
        if(newUserProperty.isEmpty()){
            throw new PKException("Data not exist");
        }

        UserProperty userProperty= userPropertyMapper.updateUserProperty(userPropertyRequestDto,newUserProperty.get());
        userPropertyRepository.save(userProperty);
        return userPropertyMapper.find(userProperty);
    }
    public List<UserPropertyResponseDTO> findAll() throws PKException {
        List<UserProperty> newUserProperty = userPropertyRepository.findByStatusNot(PKConstants.Common.STATUS_CODE_DELETE);
        List<UserPropertyResponseDTO> userProperties= new ArrayList<>();
        if(PKUtil.isCollectionNotBlank(newUserProperty)){
             userProperties = newUserProperty.stream().map(userProperty ->
                    userPropertyMapper.find(userProperty)).collect(Collectors.toList());
            return userProperties;
        }
        return userProperties;
    }

    public List<UserPropertyResponseDTO> findAllByAdmin() throws PKException {
        List<UserProperty> newUserProperty = userPropertyRepository.findAll();
        List<UserPropertyResponseDTO> userProperties = new ArrayList<>();
        if(PKUtil.isCollectionNotBlank(newUserProperty)){
            userProperties = newUserProperty.stream().map(userProperty ->
                    userPropertyMapper.find(userProperty)).collect(Collectors.toList());
            return userProperties;
        }
        return userProperties;
    }
    public UserPropertyResponseDTO findById(Long Id) throws PKException {
        Optional<UserProperty> newUserProperty = userPropertyRepository.findById(Id);
        if(newUserProperty.isEmpty()){
            throw new PKException("Data not exist");
        }
        return userPropertyMapper.findById(newUserProperty.get());
    }
    public void delete(Long Id) throws PKException {
        Optional<UserProperty> newUserProperty = userPropertyRepository.findById(Id);
        if(newUserProperty.isEmpty()){
            throw new PKException("User Property is not exist");
        }
        if(newUserProperty.get().getStatus().equals(3))
        {
            throw new PKException("User Property Already Deleted");
        }
        UserProperty userProperty= userPropertyMapper.deleteUserProperty(newUserProperty.get());
        userPropertyRepository.save(userProperty);
    }
}
