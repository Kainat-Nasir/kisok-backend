package com.conurets.parking_kiosk.base.dto.request;

import lombok.Data;

/**
 * @author Adeel Ali
 * @version 1.0
 */
@Data
public class ForgetPassword extends BaseRequestDTO {
        private String emailAddress;
}
