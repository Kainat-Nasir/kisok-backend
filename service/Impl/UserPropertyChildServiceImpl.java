package com.conurets.parking_kiosk.service.Impl;

import com.conurets.parking_kiosk.base.dto.request.UserPropertyChildRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.UserPropertyChildResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.mapper.UserPropertyChildMapper;
import com.conurets.parking_kiosk.persistence.entity.UserProperty;
import com.conurets.parking_kiosk.persistence.entity.UserPropertyChild;
import com.conurets.parking_kiosk.persistence.repository.UserPropertyChildRepository;
import com.conurets.parking_kiosk.persistence.repository.UserPropertyRepository;
import com.conurets.parking_kiosk.service.UserPropertyChildService;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserPropertyChildServiceImpl extends BaseServiceImpl implements UserPropertyChildService {

    UserPropertyRepository propertyRepository;
    UserPropertyChildRepository childRepository;
    UserPropertyChildMapper childMapper;

    @Autowired
    public UserPropertyChildServiceImpl(UserPropertyRepository propertyRepository,
                                        UserPropertyChildRepository childRepository,
                                        UserPropertyChildMapper childMapper) {
        this.propertyRepository = propertyRepository;
        this.childRepository = childRepository;
        this.childMapper = childMapper;
    }

    private void PropertyExists(UserPropertyChildRequestDTO requestDTO) throws PKException{
       Optional<UserProperty> userProperty = propertyRepository.findById(requestDTO.getUserProperty());

        if(userProperty.isEmpty()){
            throw new PKException("User property not found");
        }
    }

    @Override
    public void addUserPropertyChild(UserPropertyChildRequestDTO requestDTO) throws PKException {
        PropertyExists(requestDTO);
        UserPropertyChild child = childMapper.addChildProperty(requestDTO);
        GeometryFactory geometryFactory = new GeometryFactory();
        Point location = geometryFactory.createPoint(new Coordinate(requestDTO.getLongitude(), requestDTO.getLatitude()));
        child.setLocation(location);
        childRepository.save(child);
    }

    @Override
    public void updateUserPropertyChild(UserPropertyChildRequestDTO dto, Long Id) throws PKException {
        PropertyExists(dto);
        UserPropertyChild child = childMapper.updateChildProperty(dto,Id);
        GeometryFactory geometryFactory = new GeometryFactory();
        Point location = geometryFactory.createPoint(new Coordinate(dto.getLongitude(), dto.getLatitude()));
        child.setLocation(location);
        childRepository.save(child);
    }

    @Override
    public void deleteUserPropertyChild(Long Id) throws PKException {
        Optional<UserPropertyChild> child = childMapper.deleteChildProperty(Id);
        childRepository.save(child.get());
    }

    @Override
    public List<UserPropertyChildResponseDTO> getAllUserPropertyChildren() throws PKException {
        List<UserPropertyChild> children = childRepository.findAll();
        List<UserPropertyChildResponseDTO> childResponseDTOS = children.stream()
                .map(propertyChild -> childMapper.findChildProperty(propertyChild.getId())).collect(Collectors.toList());
        return childResponseDTOS;
    }

    @Override
    public UserPropertyChildResponseDTO getUserPropertyChildById(Long Id) throws PKException {
        UserPropertyChildResponseDTO responseDTO = childMapper.findChildProperty(Id);
        return responseDTO;
    }
}
