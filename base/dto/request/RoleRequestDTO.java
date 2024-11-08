package com.conurets.parking_kiosk.base.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.Size;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class RoleRequestDTO extends BaseRequestDTO {

    private Long id;

    @NotEmpty(message = "Role name must not be empty")
    @Size(min = 1, max = 80, message = "Role name must have valid format")
    private String roleName;

    @NotEmpty(message = "Role description must not be empty")
    @Size(min = 1, max = 80, message = "Role description must have valid format")
    private String roleDescription;

    @NotEmpty(message = "Status must not be empty")
    private Integer status;
}
