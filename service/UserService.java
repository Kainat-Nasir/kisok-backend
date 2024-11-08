package com.conurets.parking_kiosk.service;

import com.conurets.parking_kiosk.base.dto.request.UserRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.UserResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.User;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface UserService {
    void registerUser(UserRequestDTO model) throws PKException;
    UserResponseDTO addUser(UserRequestDTO model) throws PKException;
    UserResponseDTO updateUser(UserRequestDTO model,Long Id) throws PKException;
    List<UserResponseDTO> getAllUsers() throws PKException;
    UserResponseDTO findUserById(Long userId) throws PKException;
    UserResponseDTO activeUser(Long userId) throws PKException;
    UserResponseDTO deActivateUser(Long userId) throws PKException;
    void deleteUser(Long userId) throws PKException;
}
