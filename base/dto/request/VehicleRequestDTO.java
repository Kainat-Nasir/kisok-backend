package com.conurets.parking_kiosk.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class VehicleRequestDTO extends BaseRequestDTO{
    private String name;
    private int licensePlate;
    private Integer status;
    private Long userid;

}
