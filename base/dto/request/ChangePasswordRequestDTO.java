package com.conurets.parking_kiosk.base.dto.request;

import lombok.Data;

/**
 * Created by @Ibrahim Inam on 4/28/2020.
 */
@Data
public class ChangePasswordRequestDTO extends BaseRequestDTO {

    private Long userId;
    private  String emailAddress;
    private  String confirmPassword;
    private String newPassword;
    private String resetToken;
    private String currentPassword;

}
