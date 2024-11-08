package com.conurets.parking_kiosk.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserPropertyChildRequestDTO extends BaseRequestDTO {
    private String name;
    private String description;
    private int latitude;
    private int longitude;
    private Double capacity;
    private Long userProperty;
    private Integer propertyType;
    private Integer status;
}
