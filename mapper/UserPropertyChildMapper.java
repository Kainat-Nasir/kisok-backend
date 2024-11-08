package com.conurets.parking_kiosk.mapper;

import com.conurets.parking_kiosk.base.dto.request.UserPropertyChildRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.UserPropertyChildResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.PKConstants;
import com.conurets.parking_kiosk.persistence.entity.UserPropertyChild;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserPropertyChildMapper extends BaseMapper {

    public UserPropertyChild MapUserPropertyChildDetails(UserPropertyChildRequestDTO requestDTO,
                                                         UserPropertyChild propertyChild,String Operation)
            throws PKException{
        propertyChild.setName(requestDTO.getName());
        propertyChild.setDescription(requestDTO.getDescription());
        propertyChild.setCapacity(requestDTO.getCapacity());
        propertyChild.setUserProperty(getPropertyRepository().findById(requestDTO.getUserProperty()).get());
        propertyChild.setPropertyType(getPropertyTypeRepository().findById(requestDTO.getPropertyType()).get());
        if(Operation.equals("add")){
            propertyChild.setStatus(PKConstants.Common.STATUS_CODE_ACTIVE);
        }else if(Operation.equals("update")){
            propertyChild.setStatus(requestDTO.getStatus());
        }
        addAuditingInformation(propertyChild);
        return propertyChild;
    }

    public UserPropertyChild addChildProperty(UserPropertyChildRequestDTO dto){
        UserPropertyChild child = new UserPropertyChild();
        return MapUserPropertyChildDetails(dto,child,"add");
    }

    public UserPropertyChild updateChildProperty(UserPropertyChildRequestDTO dto,Long Id){
        UserPropertyChild child = getChildRepository().findById(Id).get();
        return MapUserPropertyChildDetails(dto,child,"update");
    }

    public Optional<UserPropertyChild> deleteChildProperty(Long Id){
       Optional <UserPropertyChild> child = getChildRepository().findById(Id);
        if(child.isEmpty()){
            throw new PKException("Property not found");
        }
        child.get().setStatus(PKConstants.Common.STATUS_CODE_DELETE);
        return child;
    }

    public UserPropertyChildResponseDTO findChildProperty(Long Id){
        UserPropertyChild child = getChildRepository().findById(Id).get();
        if(child == null){
            throw new PKException("Property not found");
        }

        UserPropertyChildResponseDTO responseDTO = new UserPropertyChildResponseDTO();
        responseDTO.setId(child.getId());
        responseDTO.setName(child.getName());
        responseDTO.setDescription(child.getDescription());
        responseDTO.setCapacity(child.getCapacity());
        responseDTO.setUser(child.getUserProperty());
        responseDTO.setPropertyType(child.getPropertyType());
        responseDTO.setLongitude(child.getLocation().getX());
        responseDTO.setLatitude(child.getLocation().getY());
        responseDTO.setStatus(child.getStatus());
        return responseDTO;
    }

}
