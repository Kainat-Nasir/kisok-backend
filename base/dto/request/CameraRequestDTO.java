package com.conurets.parking_kiosk.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author Kainat Nasir
 * @version 1.0
 */
@Data

@EqualsAndHashCode(callSuper = false)
public class CameraRequestDTO extends BaseRequestDTO {
    private  String name;
    private int ip;
    private String description;
    private String type;
    private Integer status;
    private Long UserPropertyChildId;
}
