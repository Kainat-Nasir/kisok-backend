package com.conurets.parking_kiosk.controller;

import com.conurets.parking_kiosk.base.dto.request.UserPropertyChildRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.BaseResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.UserPropertyChildResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.service.UserPropertyChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user-property-child/")
public class UserPropertyChildController extends BaseController{

    UserPropertyChildService userPropertyChildService;

    @Autowired
    public UserPropertyChildController(UserPropertyChildService userPropertyChildService) {
        this.userPropertyChildService = userPropertyChildService;
    }

    @PostMapping(value = "add")
    public BaseResponseDTO addUserPropertyChild(@RequestBody UserPropertyChildRequestDTO UserPropertyChildRequestDTO ) throws PKException {
        userPropertyChildService.addUserPropertyChild(UserPropertyChildRequestDTO);
        return response();
    }
    @PutMapping(value = "update/{Id}")
    public BaseResponseDTO updateUserPropertyChild(@RequestBody UserPropertyChildRequestDTO dto, @PathVariable Long Id ) throws PKException{
        userPropertyChildService.updateUserPropertyChild(dto,Id);
        return response();
    }

    @GetMapping(value = "find-all")
    public BaseResponseDTO findAllUserProperty() throws PKException {
        List<UserPropertyChildResponseDTO> children= userPropertyChildService.getAllUserPropertyChildren();
        return response(children);
    }

    @GetMapping(value = "findById/{Id}")
    public BaseResponseDTO findUserPropertyById(@PathVariable Long Id) throws PKException {
        UserPropertyChildResponseDTO childResponse= userPropertyChildService.getUserPropertyChildById(Id);
        return response(childResponse);
    }

    @DeleteMapping(value = "delete/{Id}")
    public BaseResponseDTO deleteUserProperty(@PathVariable Long Id ) throws PKException{
        userPropertyChildService.deleteUserPropertyChild(Id);
        return response();
    }
    
}
