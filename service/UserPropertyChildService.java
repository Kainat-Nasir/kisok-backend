package com.conurets.parking_kiosk.service;

import com.conurets.parking_kiosk.base.dto.request.UserPropertyChildRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.UserPropertyChildResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import java.util.List;

public interface UserPropertyChildService {
    void addUserPropertyChild(UserPropertyChildRequestDTO requestDTO) throws PKException;
    void updateUserPropertyChild(UserPropertyChildRequestDTO dto,Long Id) throws PKException;
    void deleteUserPropertyChild(Long Id) throws PKException;
    List<UserPropertyChildResponseDTO> getAllUserPropertyChildren() throws PKException;
    UserPropertyChildResponseDTO getUserPropertyChildById(Long Id) throws PKException;
}
