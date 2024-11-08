package com.conurets.parking_kiosk.base.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PermitStatusResponseDTO {
    private Long id;
    private  String name;
    private String description;
    private Integer status;
}
