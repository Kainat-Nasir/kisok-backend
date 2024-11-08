package com.conurets.parking_kiosk.controller;

import com.conurets.parking_kiosk.base.dto.request.UserPropertyRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.BaseResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.UserPropertyResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.UserResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.UserProperty;
import com.conurets.parking_kiosk.service.UserPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/user-property/")
public class UserPropertyController extends BaseController{
    UserPropertyService userPropertyService;

    @Autowired
    public UserPropertyController(UserPropertyService userPropertyService) {
        this.userPropertyService = userPropertyService;
    }
    @PostMapping(value = "add")
    public BaseResponseDTO add(@RequestBody UserPropertyRequestDTO userPropertyRequestDto ) throws PKException{
       UserPropertyResponseDTO userPropertyResponseDto= userPropertyService.add(userPropertyRequestDto);
        return response(userPropertyResponseDto);
    }
    @PutMapping(value = "update/{Id}")
    public BaseResponseDTO update(@RequestBody UserPropertyRequestDTO dto, @PathVariable Long Id ) throws PKException{
        UserPropertyResponseDTO userPropertyResponseDto= userPropertyService.update(dto,Id);
        return response(userPropertyResponseDto);
    }

    @GetMapping(value = "findAll")
    public BaseResponseDTO findAll() throws PKException {
        List<UserPropertyResponseDTO> userProperties= userPropertyService.findAll();
        return response(userProperties);
    }

    @GetMapping(value = "findByAdmin")
    public BaseResponseDTO findAllByAdmin() throws PKException {
        List<UserPropertyResponseDTO> userProperties= userPropertyService.findAllByAdmin();
        return response(userProperties);
    }

    @GetMapping(value = "findById/{Id}")
    public BaseResponseDTO findById(@PathVariable Long Id) throws PKException {
        UserPropertyResponseDTO userPropertyResponseDto= userPropertyService.findById(Id);
        return response(userPropertyResponseDto);
    }

    @PutMapping(value = "delete/{Id}")
    public BaseResponseDTO delete(@PathVariable Long Id ) throws PKException{
         userPropertyService.delete(Id);
        return response();
    }

}
