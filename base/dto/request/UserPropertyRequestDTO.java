package com.conurets.parking_kiosk.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserPropertyRequestDTO extends BaseRequestDTO {

    private String name;
    private String description;
    private Double latitude;
    private Double longitude;
    private Integer status;

}
