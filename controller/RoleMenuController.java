package com.conurets.parking_kiosk.controller;

import com.conurets.parking_kiosk.base.dto.request.RoleMenuRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.BaseResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.MenuPrivilegeResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zohaib Ahmed
 * @version 1.0
 */

@RestController
@RequestMapping(value = "/api/role-menu/")
public class RoleMenuController extends BaseController{

    RoleMenuService roleMenuService;

    @Autowired
    public RoleMenuController(RoleMenuService roleMenuService) {
        this.roleMenuService = roleMenuService;
    }

    @Autowired

    @GetMapping(value = "get-all-items")
    public BaseResponseDTO getAllRoleWithMenus() throws PKException{
        List<MenuPrivilegeResponseDTO> menuResponseDTOS =  roleMenuService.FindRoleWithMenus();
        return response(menuResponseDTOS);
    }

    @PostMapping(value = "add-menu-roles")
    public BaseResponseDTO addMenuRoles(@RequestBody RoleMenuRequestDTO roleMenuRequestDTO){
        roleMenuService.AddMenusWithRoles(roleMenuRequestDTO);
        return response();
    }
}
