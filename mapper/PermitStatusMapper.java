package com.conurets.parking_kiosk.mapper;

import com.conurets.parking_kiosk.base.dto.response.CameraResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.PermitStatusResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.Camera;
import com.conurets.parking_kiosk.persistence.entity.PermitStatus;
import com.conurets.parking_kiosk.persistence.repository.PermitStatusRepository;
import com.conurets.parking_kiosk.persistence.repository.UserPropertyChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Kainat Nasir
 * @version 1.0
 */

@Component
public class PermitStatusMapper extends BaseMapper {
    @Autowired
    private PermitStatusRepository permitStatusRepository;

    public PermitStatusResponseDTO find(PermitStatus permitStatus) throws PKException {
        PermitStatusResponseDTO response = new PermitStatusResponseDTO();
        response.setId(permitStatus.getId());
        response.setName(permitStatus.getName());
        response.setDescription(permitStatus.getDescription());
        response.setStatus(permitStatus.getStatus());
        return response;
    }
    public PermitStatusResponseDTO findById(PermitStatus permitStatus){
        PermitStatusResponseDTO responseDTO = new PermitStatusResponseDTO();
        responseDTO.setId(permitStatus.getId());
        responseDTO.setName(permitStatus.getName());
        responseDTO.setDescription(permitStatus.getDescription());
        responseDTO.setStatus(permitStatus.getStatus());
        return responseDTO;
    }
}
