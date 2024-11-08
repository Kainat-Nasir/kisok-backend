package com.conurets.parking_kiosk.service.Impl;

import com.conurets.parking_kiosk.base.dto.response.PropertyTypeResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.mapper.PropertyTypeMapper;
import com.conurets.parking_kiosk.persistence.entity.PropertyType;
import com.conurets.parking_kiosk.persistence.repository.PropertyTypeRepository;
import com.conurets.parking_kiosk.service.PropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyTypeServiceImpl extends BaseServiceImpl implements PropertyTypeService {

    PropertyTypeRepository propertyTypeRepository;
    PropertyTypeMapper propertyTypeMapper;

    @Autowired
    public PropertyTypeServiceImpl(PropertyTypeRepository propertyTypeRepository, PropertyTypeMapper propertyTypeMapper) {
        this.propertyTypeRepository = propertyTypeRepository;
        this.propertyTypeMapper = propertyTypeMapper;
    }

    @Override
    public List<PropertyTypeResponseDTO> getAllPropertyTypes() throws PKException {
        List<PropertyTypeResponseDTO> dtoList;
        List<PropertyType> propertyType = propertyTypeRepository.findAll();
        dtoList = propertyTypeMapper.getAllPropertyType(propertyType);
        return dtoList;
    }

    @Override
    public PropertyTypeResponseDTO getByPropertyTypeId(Integer Id) throws PKException {
        PropertyType propertyType = propertyTypeRepository.findById(Id).get();
        PropertyTypeResponseDTO propertyTypeResponseDTO = propertyTypeMapper.getPropertyTypeById(propertyType);
        return propertyTypeResponseDTO;
    }
}
