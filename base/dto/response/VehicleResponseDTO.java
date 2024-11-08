package com.conurets.parking_kiosk.base.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class VehicleResponseDTO {
    private Long id;
    private String name;
    private int licensePlate;
    private String firstname;
    private Integer status;
    private Long userid;

}
