package com.conurets.parking_kiosk.controller;

import com.conurets.parking_kiosk.base.dto.response.BaseResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.PropertyTypeResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.PropertyType;
import com.conurets.parking_kiosk.service.PropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/property-type/")
public class PropertyTypeController extends BaseController {

    PropertyTypeService propertyTypeService;

    @Autowired
    public PropertyTypeController(PropertyTypeService propertyTypeService) {
        this.propertyTypeService = propertyTypeService;
    }


    @GetMapping(value = "getAll")
    public BaseResponseDTO getAllPropertyType() throws PKException{
        List<PropertyTypeResponseDTO> dtoList = propertyTypeService.getAllPropertyTypes();
        return response(dtoList);
    }

    @GetMapping(value = "getById/{Id}")
    public BaseResponseDTO getPropertyTypeById(@PathVariable Integer Id) throws PKException{
        PropertyTypeResponseDTO dto = propertyTypeService.getByPropertyTypeId(Id);
        return response(dto);
    }
}
