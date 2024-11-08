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
public class UserResponseDTO implements Serializable {
    private  Long id;
    private Long privilegeId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    //--------- task id: 1417 -----------
    private String alternateEmailAddress;
    private String mobilePhone;
    private Long organizationId;
    private Long userTypeId;
    private Integer status;
    private String userTypeName;
    private RoleResponseDTO role;
}
