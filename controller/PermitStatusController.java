package com.conurets.parking_kiosk.controller;

import com.conurets.parking_kiosk.base.dto.response.BaseResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.CameraResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.PermitStatusResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.service.CameraService;
import com.conurets.parking_kiosk.service.PermitStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Kainat Nasir
 * @version 1.0
 */
@RestController
@RequestMapping("/api/permit-status")
public class PermitStatusController extends BaseController{
    @Autowired
    private PermitStatusService permitStatusService;
    @GetMapping("/findAll")
    public BaseResponseDTO findAllPermitStatus() throws PKException {
        List<PermitStatusResponseDTO> permitStatus = permitStatusService.findAllPermitStatus();
        return response(permitStatus);
    }

    @GetMapping(value = "findById/{Id}")
    public BaseResponseDTO findById(@PathVariable Long Id) throws PKException {
        PermitStatusResponseDTO permitStatus= permitStatusService.findById(Id);
        return response(permitStatus);
    }
}
