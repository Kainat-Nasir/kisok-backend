package com.conurets.parking_kiosk.service;

import com.conurets.parking_kiosk.base.dto.request.CameraRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.CameraResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;

import java.util.List;


public interface CameraService {
    List<CameraResponseDTO> getAllCameras();

    CameraResponseDTO addCamera(CameraRequestDTO dto) throws PKException;
    void delete(Long Id) throws PKException;
    CameraResponseDTO updateCamera(Long id, CameraRequestDTO dto) throws PKException;
    CameraResponseDTO getCameraById(Long Id) throws PKException;
    void activateCamera(Long id) throws PKException;
    void deactivateCamera(Long id) throws PKException;

}
