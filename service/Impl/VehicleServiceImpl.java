package com.conurets.parking_kiosk.service.Impl;

import com.conurets.parking_kiosk.base.dto.request.VehicleRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.VehicleResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.PKConstants;
import com.conurets.parking_kiosk.mapper.VehicleMapper;
import com.conurets.parking_kiosk.persistence.entity.Vehicle;
import com.conurets.parking_kiosk.persistence.repository.VehicleRepository;
import com.conurets.parking_kiosk.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl extends BaseServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleMapper vehicleMapper;


    public List<VehicleResponseDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findByStatusNot(PKConstants.Common.STATUS_CODE_DELETE);
        return vehicles.stream().map(vehicleMapper::find).collect(Collectors.toList());
    }


    public VehicleResponseDTO getVehicleById(Long Id) throws PKException {
        Optional<Vehicle> vehicle = vehicleRepository.findById(Id);
        if(vehicle.isEmpty()){
            throw new PKException("vehicle not found");
        }
        return vehicleMapper.find(vehicle.get());
    }

    public VehicleResponseDTO addVehicle(VehicleRequestDTO dto) throws PKException {

        Vehicle vehicle = vehicleMapper.add(dto);
        vehicleRepository.save(vehicle);
        return vehicleMapper.find(vehicle);
    }



    public void deleteVehicle(Long id) throws PKException {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isEmpty()) {
            throw new PKException("Vehicle not found");
        }

        // Check if the vehicle is already deleted
        if (vehicle.get().getStatus() == PKConstants.Common.STATUS_CODE_DELETE) {
            throw new PKException("Vehicle is already deleted");
        }

        // Mark vehicle as deleted and save the change
        vehicleRepository.save(vehicleMapper.delete(vehicle.get()));
    }


    public void activateVehicle(Long id) throws PKException {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isEmpty()) {
            throw new PKException("vehicle not found");
        }
        vehicleMapper.activate(vehicle.get());
        vehicleRepository.save(vehicle.get());
    }

    public void deactivateVehicle(Long id) throws PKException {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isEmpty()) {
            throw new PKException("vehicle not found");
        }
        vehicleMapper.deactivate(vehicle.get());
        vehicleRepository.save(vehicle.get());
    }

    public VehicleResponseDTO updateVehicle(Long id, VehicleRequestDTO dto) throws PKException {

        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new PKException("vehicle not found for ID: " + id));


        vehicleMapper.update(existingVehicle, dto);


        vehicleRepository.save(existingVehicle);
        return vehicleMapper.find(existingVehicle);
    }
}
