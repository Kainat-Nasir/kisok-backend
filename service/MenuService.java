package com.conurets.parking_kiosk.service;

import com.conurets.parking_kiosk.base.dto.request.MenuRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.MenuResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.Menu;

import java.util.List;

public interface MenuService {
    MenuResponseDTO addMenu(MenuRequestDTO menuRequestDTO) throws PKException;
    MenuResponseDTO updateMenu(MenuRequestDTO model) throws PKException;
    List<MenuResponseDTO> getAllMenu() throws PKException;
    void deleteMenu(Long userId) throws PKException;
}
