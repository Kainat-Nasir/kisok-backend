package com.conurets.parking_kiosk.base.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Adeel Ali
 * @version 1.0
 * @
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MenuPrivilegeResponseDTO implements Serializable {
    private Long id;
    private MenuResponseDTO menu;
    private RoleResponseDTO role;
    private Integer status;
}
