package com.conurets.parking_kiosk.service;

import com.conurets.parking_kiosk.base.dto.request.UserPropertyRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.UserPropertyResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.UserProperty;

import java.util.List;

public interface UserPropertyService {
 UserPropertyResponseDTO add(UserPropertyRequestDTO userPropertyRequestDto) throws PKException;
 UserPropertyResponseDTO update(UserPropertyRequestDTO userPropertyRequestDto ,Long Id)throws PKException;
 List<UserPropertyResponseDTO> findAll() throws PKException;
 List<UserPropertyResponseDTO> findAllByAdmin() throws PKException;
 UserPropertyResponseDTO findById(Long Id) throws PKException;
 void delete(Long Id)throws PKException;

}
