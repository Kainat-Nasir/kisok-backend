package com.conurets.parking_kiosk.mapper;

import com.conurets.parking_kiosk.base.dto.response.PropertyTypeResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.PropertyType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PropertyTypeMapper extends BaseMapper{

    private final ModelMapper modelMapper;

    @Autowired
    public PropertyTypeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<PropertyTypeResponseDTO> getAllPropertyType(List<PropertyType> propertyTypes)  throws PKException {
        List<PropertyTypeResponseDTO> dtoList = new ArrayList<>();
        dtoList = modelMapper.map(propertyTypes,dtoList.getClass());
        return dtoList;
    }

    public PropertyTypeResponseDTO getPropertyTypeById(PropertyType propertyType)  throws PKException {
        PropertyTypeResponseDTO dto = new PropertyTypeResponseDTO();
        dto = modelMapper.map(propertyType,dto.getClass());
        return dto;
    }
}
