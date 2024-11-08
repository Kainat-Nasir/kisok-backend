package com.conurets.parking_kiosk.mapper;

import com.conurets.parking_kiosk.base.dto.request.ChildFloorRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.ChildFloorResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.PKConstants;
import com.conurets.parking_kiosk.persistence.entity.ChildFloor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChildFloorMapper extends BaseMapper {

    UserPropertyChildMapper userPropertyChildMapper;

    @Autowired
    public ChildFloorMapper(UserPropertyChildMapper userPropertyChildMapper) {
        this.userPropertyChildMapper = userPropertyChildMapper;
    }

    private ChildFloor MapRequestDetails(ChildFloorRequestDTO dto, ChildFloor floor) throws PKException{
        floor.setName(dto.getName());
        floor.setDescription(dto.getDescription());
        floor.setStatus(dto.getStatus());
        try {
            ChildFloor.PropertyTypeEnum propertyTypeEnum = ChildFloor.PropertyTypeEnum.valueOf(dto.getFloorType().toUpperCase());
            floor.setFloorType(propertyTypeEnum.name());
        } catch (IllegalArgumentException e) {
            throw new PKException("Invalid floor type specified: " + dto.getFloorType());
        }
        floor.setUserPropertyChild(getChildRepository().findById(dto.getChildProperty()).get());
        addAuditingInformation(floor);
        return floor;
    }

    public ChildFloor addFloor(ChildFloorRequestDTO requestDTO) throws PKException{
        ChildFloor floor = new ChildFloor();
        return MapRequestDetails(requestDTO,floor);
    }

    public ChildFloor updateChildFloor(ChildFloorRequestDTO dto, Long Id) throws PKException{
        ChildFloor floor = getFloorRepository().findById(Id).get();
        return MapRequestDetails(dto,floor);
    }

    public ChildFloor deleteChildFloor(Long Id) throws PKException{
        ChildFloor floor = getFloorRepository().findById(Id).get();
        floor.setStatus(PKConstants.Common.STATUS_CODE_DELETE);
        addAuditingInformation(floor);
        return floor;
    }

    public ChildFloorResponseDTO getFloorDetails(ChildFloor floor) throws PKException{
        ChildFloorResponseDTO responseDTO = new ChildFloorResponseDTO();
        responseDTO.setId(floor.getId());
        responseDTO.setName(floor.getName());
        responseDTO.setDescription(floor.getDescription());
        responseDTO.setStatus(floor.getStatus());
        responseDTO.setFloorType(floor.getFloorType());
        responseDTO.setCreatedBy(floor.getCreatedBy());
        responseDTO.setCreatedDate(floor.getCreatedDate());
        responseDTO.setLastUpdateBy(floor.getLastUpdateBy() == null ? 0 : floor.getLastUpdateBy());
        responseDTO.setLastUpdate(floor.getLastUpdate());
        return responseDTO;

    }
}
