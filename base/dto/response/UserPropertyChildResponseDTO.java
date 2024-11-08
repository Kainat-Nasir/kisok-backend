package com.conurets.parking_kiosk.base.dto.response;

import com.conurets.parking_kiosk.persistence.entity.PropertyType;
import com.conurets.parking_kiosk.persistence.entity.User;
import com.conurets.parking_kiosk.persistence.entity.UserProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class UserPropertyChildResponseDTO extends BaseResponseDTO{
    private Long Id;
    private String name;
    private String description;
    private Double latitude;
    private Double longitude;
    private Double capacity;
    private UserProperty user;
    private PropertyType propertyType;
    private Integer status;
}
