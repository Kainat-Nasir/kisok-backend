package com.conurets.parking_kiosk.service.Impl;

import com.conurets.parking_kiosk.base.dto.request.ChildFloorRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.ChildFloorResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.mapper.ChildFloorMapper;
import com.conurets.parking_kiosk.persistence.entity.ChildFloor;
import com.conurets.parking_kiosk.persistence.repository.ChildFloorRepository;
import com.conurets.parking_kiosk.service.ChildFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildFloorServiceImpl extends BaseServiceImpl implements ChildFloorService {

    ChildFloorMapper childFloorMapper;
    ChildFloorRepository repository;

    @Autowired
    public ChildFloorServiceImpl(ChildFloorMapper childFloorMapper,ChildFloorRepository repository) {
        this.childFloorMapper = childFloorMapper;
        this.repository = repository;
    }

    @Override
    public void addFloor(ChildFloorRequestDTO childFloor) throws PKException {
        repository.save(childFloorMapper.addFloor(childFloor));
    }

    @Override
    public void updateFloor(ChildFloorRequestDTO floor, Long Id) throws PKException {
        repository.save(childFloorMapper.updateChildFloor(floor,Id));
    }

    @Override
    public void deleteFloor(Long Id) throws PKException {
        repository.save(childFloorMapper.deleteChildFloor(Id));
    }

    @Override
    public List<ChildFloorResponseDTO> getAllChildFloors() throws PKException {
        List<ChildFloor> childFloors = repository.findAll();
        List<ChildFloorResponseDTO> dtoList = childFloors.stream()
                .map(floor -> childFloorMapper.getFloorDetails(floor)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public ChildFloorResponseDTO getFloorById(Long Id) throws PKException {
        ChildFloor floor = repository.findById(Id).get();
        return childFloorMapper.getFloorDetails(floor);
    }

    @Override
    public List<ChildFloorResponseDTO> getAllFloorsByParentId(Long Id) throws PKException {
        List<ChildFloor> childFloors = repository.findAllByUserPropertyChild(Id);

        List<ChildFloorResponseDTO> floorResponseDTOS = childFloors.stream().map(floor -> childFloorMapper.getFloorDetails(floor)).collect(Collectors.toList());
        return floorResponseDTOS;
    }
}
