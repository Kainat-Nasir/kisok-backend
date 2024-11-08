package com.conurets.parking_kiosk.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ChildFloorRequestDTO extends BaseRequestDTO {
    private String name;
    private String description;
    private Integer status;
    private String floorType;
    private Long childProperty;
}
