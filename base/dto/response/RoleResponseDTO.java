package com.conurets.parking_kiosk.base.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class RoleResponseDTO implements Serializable {
    private Long Id;
    private String roleName;
    private String roleDescription;
    private Integer status;
}
