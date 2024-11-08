package com.conurets.parking_kiosk.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserRoleRequestDTO extends BaseRequestDTO {
    Long Id;
    Long roleId;
    Long userId;
    Long status;
}
