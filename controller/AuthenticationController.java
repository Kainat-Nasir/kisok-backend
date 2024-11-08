package com.conurets.parking_kiosk.controller;

import com.conurets.parking_kiosk.base.dto.request.AuthenticationRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.AuthenticationResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.BaseResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController extends BaseController{

    AuthenticationService authenticationService;

    @Autowired
    AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping(value = "/api/authenticate")
    public BaseResponseDTO authenticate(@RequestBody @Valid AuthenticationRequestDTO model) throws PKException {
        AuthenticationResponseDTO dto = authenticationService.authenticate(model);
        return response(dto);
    }
}
