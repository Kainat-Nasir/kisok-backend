package com.conurets.parking_kiosk.base.dto.response;

import com.conurets.parking_kiosk.persistence.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserPropertyResponseDTO implements Serializable {
    private UserResponseDTO user;
    private Long id;
    private String name;
    private String description;
    private Double latitude;
    private Double longitude;
    private int status;
}
