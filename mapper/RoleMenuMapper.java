package com.conurets.parking_kiosk.mapper;

import com.conurets.parking_kiosk.base.dto.request.RoleMenuRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.MenuPrivilegeResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.Menu;
import com.conurets.parking_kiosk.persistence.entity.Role;
import com.conurets.parking_kiosk.persistence.entity.RoleMenu;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zohaib Ahmed
 * @version 1.0
 */

@Component
public class RoleMenuMapper extends BaseMapper {

    private final ModelMapper modelMapper;

    public RoleMenuMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<MenuPrivilegeResponseDTO> FindRoleWithMenus(List<RoleMenu> roleMenus) throws PKException {
        List<MenuPrivilegeResponseDTO> responseDTOS = new ArrayList<>();
        responseDTOS = modelMapper.map(roleMenus,responseDTOS.getClass());
        return responseDTOS;
    }

    public RoleMenu addRoleMenu(RoleMenuRequestDTO roleMenuRequestDTO, Menu menu, Role role) throws PKException{
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRole(role);
        roleMenu.setMenu(menu);
        roleMenu.setStatus(roleMenuRequestDTO.getStatus());
        addAuditingInformation(roleMenu);
        return roleMenu;
    }
}
