package com.conurets.parking_kiosk.service;

import com.conurets.parking_kiosk.base.dto.request.CameraRequestDTO;
import com.conurets.parking_kiosk.base.dto.request.VehicleRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.CameraResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.VehicleResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;

import java.util.List;

public interface VehicleService {
    List<VehicleResponseDTO> getAllVehicles();
    VehicleResponseDTO getVehicleById(Long Id) throws PKException;

    void activateVehicle(Long id) throws PKException;
    void deactivateVehicle(Long id) throws PKException;
    void deleteVehicle(Long id ) throws PKException;
    VehicleResponseDTO addVehicle(VehicleRequestDTO dto) throws PKException;
    VehicleResponseDTO updateVehicle(Long id, VehicleRequestDTO dto) throws PKException;

}
