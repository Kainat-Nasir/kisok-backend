package com.conurets.parking_kiosk.controller;

import com.conurets.parking_kiosk.base.dto.request.ChildFloorRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.BaseResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.ChildFloorResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.service.ChildFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/child-floor/")
public class ChildFloorController extends BaseController {

    ChildFloorService childFloorService;

    @Autowired
    public ChildFloorController(ChildFloorService childService) {
        this.childFloorService = childService;
    }

    @PostMapping(value = "add")
    public BaseResponseDTO addChildFloor(@RequestBody ChildFloorRequestDTO service ) throws PKException {
        childFloorService.addFloor(service);
        return response();
    }
    @PutMapping(value = "update/{Id}")
    public BaseResponseDTO updateChildFloor(@RequestBody ChildFloorRequestDTO dto, @PathVariable Long Id ) throws PKException{
        childFloorService.updateFloor(dto,Id);
        return response();
    }

    @GetMapping(value = "find-all")
    public BaseResponseDTO findAllChildFloors() throws PKException {
        List<ChildFloorResponseDTO> children= childFloorService.getAllChildFloors();
        return response(children);
    }

    @GetMapping(value = "findById/{Id}")
    public BaseResponseDTO findChildFloorById(@PathVariable Long Id) throws PKException {
        ChildFloorResponseDTO childResponse= childFloorService.getFloorById(Id);
        return response(childResponse);
    }

    @GetMapping(value = "findByParentId/{Id}")
    public BaseResponseDTO findChildFloorByParentId(@PathVariable Long Id) throws PKException {
        List<ChildFloorResponseDTO> childResponse= childFloorService.getAllFloorsByParentId(Id);
        return response(childResponse);
    }

    @DeleteMapping(value = "delete/{Id}")
    public BaseResponseDTO deleteChildFloor(@PathVariable Long Id ) throws PKException{
        childFloorService.deleteFloor(Id);
        return response();
    }
}
