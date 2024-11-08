package com.conurets.parking_kiosk.controller;
import com.conurets.parking_kiosk.base.dto.request.CameraRequestDTO;
import com.conurets.parking_kiosk.base.dto.request.UserPropertyChildRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.BaseResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.CameraResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.UserPropertyChildResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;

import com.conurets.parking_kiosk.service.CameraService;
import com.conurets.parking_kiosk.service.Impl.CameraServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kainat Nasir
 * @version 1.0
 */
@RestController
@RequestMapping("/api/cameras")
public class CameraController extends BaseController{
    @Autowired
    private CameraService cameraService;
    @GetMapping("/findAll")
    public BaseResponseDTO getAllCameras() throws PKException{
        List<CameraResponseDTO> cameras = cameraService.getAllCameras();
        return response(cameras);
    }
    @GetMapping(value = "findById/{Id}")
    public BaseResponseDTO findById(@PathVariable Long Id) throws PKException {
       CameraResponseDTO cameraResponse= cameraService.getCameraById(Id);
        return response(cameraResponse);
    }

    @PostMapping("/add")
    public BaseResponseDTO addCamera( @RequestBody CameraRequestDTO dto) throws PKException {
         cameraService.addCamera(dto);
        return response();
    }
    @PutMapping("/update/{id}")
    public BaseResponseDTO updateCamera(
            @PathVariable Long id,
             @RequestBody CameraRequestDTO dto) throws PKException {

        cameraService.updateCamera(id, dto);
        return response();
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponseDTO deleteCamera(@PathVariable Long id) throws PKException {
        cameraService.delete(id);
        return response();
    }
    @GetMapping("/activate/{id}")
    public BaseResponseDTO activateCamera(@PathVariable Long id) throws PKException {
        cameraService.activateCamera(id);
        return response("Camera activated successfully");
    }

    @GetMapping("/deactivate/{id}")
    public BaseResponseDTO deactivateCamera(@PathVariable Long id) throws PKException {
        cameraService.deactivateCamera(id);
        return response("Camera deactivated successfully");
    }
}
