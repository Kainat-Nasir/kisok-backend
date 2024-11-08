package com.conurets.parking_kiosk.base.dto.request;

import com.conurets.parking_kiosk.base.dto.response.BaseResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PropertyTypeRequestDTO extends BaseResponseDTO {
    private String name;
    private Integer status;
}
