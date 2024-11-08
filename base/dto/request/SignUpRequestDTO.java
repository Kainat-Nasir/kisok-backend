package com.conurets.parking_kiosk.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class SignUpRequestDTO {
    private String firstName;
    private String lastName;
    private String emailAddress;
    //private String alternateEmailAddress;
    private String mobilePhone;
    //private Long organizationId;
    private String password;
    private Boolean isHandicap;


}
