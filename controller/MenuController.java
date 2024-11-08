package com.conurets.parking_kiosk.controller;

import com.conurets.parking_kiosk.base.dto.request.MenuRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.BaseResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.MenuResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.service.MenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zohaib Ahmed
 * @version 1.0
 */

@RestController
@RequestMapping(value = "/api/menu")
public class MenuController extends BaseController{

    MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    //Fetch All Menu Items
    @GetMapping(value = "/find-all-menu-items")
    public BaseResponseDTO getAllUsers() throws PKException {
        List<MenuResponseDTO> menuResponseDTOS =  menuService.getAllMenu();
        return response(menuResponseDTOS);
    }

    //Inserting a new user
    @PostMapping(value = "/add-menu")
    public BaseResponseDTO addUser(@RequestBody @Valid MenuRequestDTO model) throws PKException {
        MenuResponseDTO menu =  menuService.addMenu(model);
        return response(menu);
    }

    //Update an existing user
    @PutMapping(value = "/update-menu")
    public BaseResponseDTO updateUser(@RequestBody @Valid MenuRequestDTO model) throws PKException {
        if(model.getId() == null){
            return response(HttpStatus.BAD_REQUEST,"No ID provided");
        }else if (model.getId() == model.getParentMenu()){
            return response(HttpStatus.BAD_REQUEST,"Parent cannot be assigned same ID");
        }
        MenuResponseDTO menuResponseDTO = menuService.updateMenu(model);
        return response(menuResponseDTO);
    }

    //Deleting a menu
    @DeleteMapping(value = "/delete-menu/{menuID}")
    public BaseResponseDTO deleteUser(@PathVariable Long menuID) throws PKException {
        menuService.deleteMenu(menuID);
        return response();
    }
}
