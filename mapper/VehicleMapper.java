package com.conurets.parking_kiosk.mapper;


import com.conurets.parking_kiosk.base.dto.request.VehicleRequestDTO;

import com.conurets.parking_kiosk.base.dto.response.VehicleResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.PKConstants;

import com.conurets.parking_kiosk.persistence.entity.User;
import com.conurets.parking_kiosk.persistence.entity.Vehicle;
import com.conurets.parking_kiosk.persistence.repository.UserRepository;
import com.conurets.parking_kiosk.security.util.PKSecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Kainat Nasir
 * @version 1.0
 */

@Component
public class VehicleMapper extends BaseMapper {
    @Autowired
    private UserRepository userRepository;
    public Vehicle add(VehicleRequestDTO dto) throws PKException {

        Vehicle vehicle = new Vehicle();
        vehicle.setName(dto.getName());
        vehicle.setStatus(PKConstants.Common.STATUS_CODE_ACTIVE);
        vehicle.setLicensePlate(dto.getLicensePlate());

        User user =userRepository.findById(PKSecurityUtil.getLoggedInUserId())
                .orElseThrow(() -> new PKException("User not found for ID: " + dto.getUserid()));

        vehicle.setUser(user);
        addAuditingInformation(vehicle);

        return vehicle;
    }
    public VehicleResponseDTO find(Vehicle vehicle) throws PKException {
        VehicleResponseDTO response = new VehicleResponseDTO();
        response.setId(vehicle.getId());
        response.setName(vehicle.getName());
        response.setStatus(vehicle.getStatus());
        response.setLicensePlate(vehicle.getLicensePlate());
        response.setFirstname(vehicle.getUser().getFirstName());
        response.setUserid(vehicle.getUser().getId());

        return response;
    }
    public Vehicle delete(Vehicle vehicle) {
        vehicle.setStatus(PKConstants.Common.STATUS_CODE_DELETE);
        return vehicle;
    }
    public Vehicle activate(Vehicle vehicle) throws PKException {
        vehicle.setStatus(PKConstants.Common.STATUS_CODE_ACTIVE);
        return vehicle;
    }
    public Vehicle deactivate(Vehicle vehicle) throws PKException {
        vehicle.setStatus(PKConstants.Common.STATUS_CODE_INACTIVE);
        return vehicle;
    }
    public void update(Vehicle vehicle, VehicleRequestDTO dto) throws PKException {
        vehicle.setName(dto.getName());
        vehicle.setLicensePlate(dto.getLicensePlate());
        vehicle.setStatus(dto.getStatus());

        // Update if it exists
        if (dto.getUserid() != null) {
            User user = userRepository.findById(PKSecurityUtil.getLoggedInUserId())
                    .orElseThrow(() -> new PKException("User not found for ID: " + dto.getUserid()));
            vehicle.setUser(user);
        }
        addAuditingInformation(vehicle);
    }
}
