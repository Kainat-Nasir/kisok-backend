package com.conurets.parking_kiosk.service.Impl;

import com.conurets.parking_kiosk.base.dto.request.CameraRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.CameraResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.mapper.CameraMapper;
import com.conurets.parking_kiosk.persistence.entity.Camera;
import com.conurets.parking_kiosk.persistence.repository.CameraRepository;
import com.conurets.parking_kiosk.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Kainat Nasir
 * @version 1.0
 */
@Service
public class CameraServiceImpl extends BaseServiceImpl implements CameraService {
    @Autowired
    private CameraRepository cameraRepository;

    @Autowired
    private CameraMapper cameraMapper;

    public List<CameraResponseDTO> getAllCameras() {
        List<Camera> cameras = cameraRepository.findAll();
        return cameras.stream().map(cameraMapper::find).collect(Collectors.toList());
    }

    public CameraResponseDTO addCamera(CameraRequestDTO dto) throws PKException {
        // Convert DTO to Camera entity
        Camera camera = cameraMapper.add(dto);

        // Save entity to repository
        cameraRepository.save(camera);

        // Map saved entity to response DTO
        return cameraMapper.find(camera);
    }

    public CameraResponseDTO updateCamera(Long id, CameraRequestDTO dto) throws PKException {
        // Find the existing Camera entity
        Camera existingCamera = cameraRepository.findById(id)
                .orElseThrow(() -> new PKException("Camera not found for ID: " + id));

        // Use the mapper to update the existing camera
        cameraMapper.update(existingCamera, dto);

        // Save updated Camera entity
        cameraRepository.save(existingCamera);
        return cameraMapper.find(existingCamera);
    }

    public void delete(Long Id) throws PKException {
        Optional<Camera> camera = cameraRepository.findById(Id);
        if(camera.isEmpty()){
            throw new PKException("Property not found");
        }
        cameraMapper.delete(camera.get());
        cameraRepository.save(camera.get());
    }

    public CameraResponseDTO getCameraById(Long Id) throws PKException {
        Optional<Camera> camera = cameraRepository.findById(Id);
        if(camera.isEmpty()){
            throw new PKException("Property not found");
        }
        return cameraMapper.findCameraById(camera.get());
    }

    public void activateCamera(Long id) throws PKException {
        Optional<Camera> camera = cameraRepository.findById(id);
        if (camera.isEmpty()) {
            throw new PKException("camera not found");
        }
        cameraMapper.activateCamera(camera.get());
        cameraRepository.save(camera.get());
    }

    public void deactivateCamera(Long id) throws PKException {
        Optional<Camera> camera = cameraRepository.findById(id);
        if (camera.isEmpty()) {
            throw new PKException("camera not found");
        }
        cameraMapper.deactivateCamera(camera.get());
        cameraRepository.save(camera.get());
    }

}
