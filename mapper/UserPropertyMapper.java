package com.conurets.parking_kiosk.mapper;

import com.conurets.parking_kiosk.base.dto.request.UserPropertyRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.UserPropertyResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.UserResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.PKConstants;
import com.conurets.parking_kiosk.persistence.entity.UserProperty;
import com.conurets.parking_kiosk.persistence.repository.UserPropertyRepository;
import com.conurets.parking_kiosk.persistence.repository.UserRepository;
import com.conurets.parking_kiosk.security.util.PKSecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPropertyMapper extends BaseMapper {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserPropertyRepository userPropertyRepository;

    private UserProperty MapRequestDetails(UserPropertyRequestDTO request, UserProperty userProperty, String operation){
        userProperty.setName(request.getName());
        userProperty.setDescription(request.getDescription());
        userProperty.setLatitude(request.getLatitude());
        userProperty.setLongitude(request.getLongitude());
        userProperty.setStatus(PKConstants.Common.STATUS_CODE_ACTIVE);
        userProperty.setUser(userRepository.findById(PKSecurityUtil.getLoggedInUserId()).get());
        addAuditingInformation(userProperty);
        return userProperty;
    }

    public UserProperty addUserProperty(UserPropertyRequestDTO request) throws PKException
    {
        UserProperty userProperty=new UserProperty();
        userProperty.setName(request.getName());
        userProperty.setDescription(request.getDescription());
        userProperty.setLatitude(request.getLatitude());
        userProperty.setLongitude(request.getLongitude());
        userProperty.setStatus(PKConstants.Common.STATUS_CODE_ACTIVE);
        userProperty.setUser(userRepository.findById(PKSecurityUtil.getLoggedInUserId()).get());
        addAuditingInformation(userProperty);
        return userProperty;
    }

    public UserPropertyResponseDTO find(UserProperty userProperty) throws PKException {
        UserPropertyResponseDTO userPropertyResponseDto = new UserPropertyResponseDTO();

        UserResponseDTO userResponseDTO=userMapper.find(userProperty.getUser());


        userPropertyResponseDto.setUser(userResponseDTO);
        userPropertyResponseDto.setId(userProperty.getId());
        userPropertyResponseDto.setName(userProperty.getName());
        userPropertyResponseDto.setDescription(userProperty.getDescription());
        userPropertyResponseDto.setLongitude(userProperty.getLongitude());
        userPropertyResponseDto.setLatitude(userProperty.getLatitude());
        userPropertyResponseDto.setStatus(userProperty.getStatus());
        return userPropertyResponseDto;
    }

    public UserProperty updateUserProperty(UserPropertyRequestDTO userPropertyRequestDto, UserProperty newUserProperty) throws PKException {
        newUserProperty.setName(userPropertyRequestDto.getName());
        newUserProperty.setDescription(userPropertyRequestDto.getDescription());
        newUserProperty.setLatitude(userPropertyRequestDto.getLatitude());
        newUserProperty.setLongitude(userPropertyRequestDto.getLongitude());
        newUserProperty.setStatus(userPropertyRequestDto.getStatus());
        newUserProperty.setUser(userRepository.findById(PKSecurityUtil.getLoggedInUserId()).get());
        addAuditingInformation(newUserProperty);
        return newUserProperty;
    }

    public UserPropertyResponseDTO findById(UserProperty userProperty) throws PKException {
       UserPropertyResponseDTO userPropertyResponseDTO=new UserPropertyResponseDTO();
       userPropertyResponseDTO.setName(userProperty.getName());
       userPropertyResponseDTO.setDescription(userProperty.getDescription());
       userPropertyResponseDTO.setLatitude(userProperty.getLatitude());
       userPropertyResponseDTO.setLongitude(userProperty.getLongitude());
        UserResponseDTO userResponseDTO = userMapper.find(userProperty.getUser());
       userPropertyResponseDTO.setUser(userResponseDTO);
       userPropertyResponseDTO.setStatus(userProperty.getStatus());
        return userPropertyResponseDTO;
    }
    public UserProperty deleteUserProperty(UserProperty newUserProperty) throws PKException {
        newUserProperty.setStatus(PKConstants.Common.STATUS_CODE_DELETE);
        addAuditingInformation(newUserProperty);
        return newUserProperty;
    }


}
