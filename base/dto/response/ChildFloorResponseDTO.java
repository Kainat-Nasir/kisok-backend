package com.conurets.parking_kiosk.base.dto.response;

import com.conurets.parking_kiosk.base.dto.request.BaseRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode (callSuper = false)
public class ChildFloorResponseDTO extends BaseRequestDTO {

    private Long Id;
    private String name;
    private String description;
    private Integer status;
    private String floorType;
}
