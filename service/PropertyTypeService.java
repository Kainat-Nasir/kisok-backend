package com.conurets.parking_kiosk.service;

import com.conurets.parking_kiosk.base.dto.response.PropertyTypeResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.PropertyType;

import java.util.List;

public interface PropertyTypeService {
    List<PropertyTypeResponseDTO> getAllPropertyTypes() throws PKException;
    PropertyTypeResponseDTO getByPropertyTypeId(Integer Id) throws PKException;
}
