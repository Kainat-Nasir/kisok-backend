package com.conurets.parking_kiosk.mapper;

import com.conurets.parking_kiosk.base.dto.request.CameraRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.CameraResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.PKConstants;
import com.conurets.parking_kiosk.persistence.entity.Camera;
import com.conurets.parking_kiosk.persistence.entity.UserPropertyChild;
import com.conurets.parking_kiosk.persistence.repository.UserPropertyChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * @author Kainat Nasir
 * @version 1.0
 */

@Component
public class CameraMapper extends BaseMapper{
    @Autowired
    private UserPropertyChildRepository userPropertyChildRepository;
    public Camera add(CameraRequestDTO dto) throws PKException {
        Camera camera = new Camera();
        camera.setName(dto.getName());
        camera.setIp(dto.getIp());
        camera.setDescription(dto.getDescription());
        camera.setType(dto.getType());
        camera.setStatus(dto.getStatus());

        UserPropertyChild userPropertyChild = userPropertyChildRepository.findById(dto.getUserPropertyChildId())
                .orElseThrow(() -> new PKException("UserPropertyChild not found for ID: " + dto.getUserPropertyChildId()));

        camera.setUserPropertyChild(userPropertyChild);
        addAuditingInformation(camera);

        return camera;
    }
    public CameraResponseDTO find(Camera camera) throws PKException {
        CameraResponseDTO response = new CameraResponseDTO();
        response.setId(camera.getId());
        response.setName(camera.getName());
        response.setIp(camera.getIp());
        response.setDescription(camera.getDescription());
        response.setType(camera.getType());
        response.setStatus(camera.getStatus());
        response.setUserPropertyChildId(camera.getUserPropertyChild().getId());

        return response;
    }
    public void update(Camera camera, CameraRequestDTO dto) throws PKException {
        camera.setName(dto.getName());
        camera.setIp(dto.getIp());
        camera.setDescription(dto.getDescription());
        camera.setType(dto.getType());
        camera.setStatus(dto.getStatus());

        // Update UserPropertyChild if it exists
        if (dto.getUserPropertyChildId() != null) {
            UserPropertyChild userPropertyChild = userPropertyChildRepository.findById(dto.getUserPropertyChildId())
                    .orElseThrow(() -> new PKException("UserPropertyChild not found for ID: " + dto.getUserPropertyChildId()));
            camera.setUserPropertyChild(userPropertyChild);
        }
        addAuditingInformation(camera);
    }
    public Camera delete(Camera camera) {
        camera.setStatus(PKConstants.Common.STATUS_CODE_DELETE);
        return camera;
    }
    public Camera activateCamera(Camera camera) throws PKException {
        camera.setStatus(PKConstants.Common.STATUS_CODE_ACTIVE); // Use an active status code
        return camera;
    }
    public Camera deactivateCamera(Camera camera) throws PKException {
        camera.setStatus(PKConstants.Common.STATUS_CODE_INACTIVE); // Use an inactive status code
        return camera;
    }
    public CameraResponseDTO findCameraById(Camera camera){
        CameraResponseDTO responseDTO = new CameraResponseDTO();
        responseDTO.setId(camera.getId());
        responseDTO.setName(camera.getName());
        responseDTO.setDescription(camera.getDescription());
        responseDTO.setIp(camera.getIp());
        responseDTO.setType(camera.getType());
        responseDTO.setStatus(camera.getStatus());
        responseDTO.setUserPropertyChildId(camera.getUserPropertyChild().getId());

        return responseDTO;
    }
}
