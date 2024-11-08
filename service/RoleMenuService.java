package com.conurets.parking_kiosk.service;

import com.conurets.parking_kiosk.base.dto.request.RoleMenuRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.MenuPrivilegeResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;

import java.util.List;

public interface RoleMenuService {
    List<MenuPrivilegeResponseDTO> FindRoleWithMenus()throws PKException;
    void AddMenusWithRoles(RoleMenuRequestDTO roleMenuRequestDTO) throws PKException;
}
