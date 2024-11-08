package com.conurets.parking_kiosk.base.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class RoleMenuRequestDTO extends BaseRequestDTO {
    private Long Id;
    @NotEmpty(message = "Role must not be empty")
    private Long roleId;

    @NotEmpty(message = "Menu must not be empty")
    private List<Long> menuId;

    @NotEmpty(message = "Status must not be empty")
    private Integer status;
}
