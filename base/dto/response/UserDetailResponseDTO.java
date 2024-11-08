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
public class UserDetailResponseDTO implements Serializable {
    private Long userId;
    private String emailAddress;
    private String alternateEmailAddress;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private Long organizationId;
    private Long userTypeId;
    private String status;
    private List<RoleResponseDTO> userRole;
}
