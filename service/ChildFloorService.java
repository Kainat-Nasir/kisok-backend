package com.conurets.parking_kiosk.service;

import com.conurets.parking_kiosk.base.dto.request.ChildFloorRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.ChildFloorResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.ChildFloor;

import java.util.List;

public interface ChildFloorService {

    void addFloor(ChildFloorRequestDTO childFloor) throws PKException;
    void updateFloor(ChildFloorRequestDTO floor, Long Id) throws PKException;
    void deleteFloor(Long Id) throws PKException;
    List<ChildFloorResponseDTO> getAllChildFloors() throws PKException;
    ChildFloorResponseDTO getFloorById(Long Id) throws PKException;
    List<ChildFloorResponseDTO> getAllFloorsByParentId(Long Id) throws PKException;
}
