package com.conurets.parking_kiosk.base.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class PropertyTypeResponseDTO implements Serializable {
    private Integer Id;
    private String name;
    private Integer status;
}
