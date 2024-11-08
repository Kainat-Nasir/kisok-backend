package com.conurets.parking_kiosk.service;

import com.conurets.parking_kiosk.base.dto.response.CameraResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.PermitStatusResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;

import java.util.List;

public interface PermitStatusService {
    List<PermitStatusResponseDTO> findAllPermitStatus();
    PermitStatusResponseDTO findById(Long Id) throws PKException;

}
