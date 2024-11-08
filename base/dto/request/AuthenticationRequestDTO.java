package com.conurets.parking_kiosk.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthenticationRequestDTO implements Serializable {
    @NotEmpty(message = "Origin must not be empty")
    @Size(min = 1, max = 10, message = "Origin must have valid format")
    private String origin;

    @NotEmpty(message = "Email address must not be empty")
    @Size(min = 1, max = 80, message = "Email address must have valid format")
    private String emailAddress;

    @NotEmpty(message = "Password must not be empty")
    @Size(min = 1, max = 80, message = "Password must have valid format")
    private String password;
}