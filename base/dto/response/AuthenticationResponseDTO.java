package com.conurets.parking_kiosk.base.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthenticationResponseDTO implements Serializable {
    private Long userId;
    private String displayName;
    private String accessToken;
    private String role;
    private String userTypeName;
    private Long userTypeId;
    private List<MenuResponseDTO> menus;
}
