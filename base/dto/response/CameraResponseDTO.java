package com.conurets.parking_kiosk.base.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Kainat Nasir
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CameraResponseDTO {
    private Long id;
    private  String name;
    private int ip;
    private String description;
    private String type;
    private Integer status;
    private Long UserPropertyChildId;
}
