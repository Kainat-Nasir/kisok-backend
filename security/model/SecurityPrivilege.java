package com.conurets.parking_kiosk.security.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Data
@Builder
public class SecurityPrivilege implements Serializable {
    private String privilegeName;
    private Boolean readOnly;
}