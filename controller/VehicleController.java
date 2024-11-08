package com.conurets.parking_kiosk.controller;


import com.conurets.parking_kiosk.base.dto.request.CameraRequestDTO;
import com.conurets.parking_kiosk.base.dto.request.VehicleRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.BaseResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.CameraResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.VehicleResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kainat Nasir
 * @version 1.0
 */
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController extends BaseController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add")
    public BaseResponseDTO addVehicle(@RequestBody VehicleRequestDTO dto) throws PKException {
        vehicleService.addVehicle(dto);
        return response();
    }
    @GetMapping(value = "findById/{Id}")
    public BaseResponseDTO findVehicleById(@PathVariable Long Id) throws PKException {
        VehicleResponseDTO vehicleResponse= vehicleService.getVehicleById(Id);
        return response(vehicleResponse);
    }

    @GetMapping("/findAll")
    public BaseResponseDTO getAllVehicles() throws PKException{
        List<VehicleResponseDTO> vehicles = vehicleService.getAllVehicles();
        return response(vehicles);
    }
    @DeleteMapping("/delete/{id}")
    public BaseResponseDTO deleteVehicle(@PathVariable Long id) throws PKException {
        vehicleService.deleteVehicle(id);
        return response();
    }
    @GetMapping("/activate/{id}")
    public BaseResponseDTO activateVehicle(@PathVariable Long id) throws PKException {
        vehicleService.activateVehicle(id);
        return response("Vehicle activated successfully");
    }

    @GetMapping("/deactivate/{id}")
    public BaseResponseDTO deactivateVehicle(@PathVariable Long id) throws PKException {
        vehicleService.deactivateVehicle(id);
        return response("Vehicle deactivated successfully");
    }
    @PutMapping("/update/{id}")
    public BaseResponseDTO updateVehicle(
            @PathVariable Long id,
            @RequestBody VehicleRequestDTO dto) throws PKException {

        vehicleService.updateVehicle(id, dto);
        return response();
    }
}
