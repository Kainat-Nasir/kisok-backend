package com.conurets.parking_kiosk.base.dto.request;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.Nullable;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class UserRequestDTO extends BaseRequestDTO {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String alternateEmailAddress;
    private String mobilePhone;
    private Integer status;
    private String password;
    private Long roleId;
}