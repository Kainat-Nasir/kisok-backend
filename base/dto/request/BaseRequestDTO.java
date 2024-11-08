package com.conurets.parking_kiosk.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRequestDTO implements Serializable {
    private String origin;
    private Timestamp createdDate;
    private Long createdBy;
    private Timestamp lastUpdate;
    private Long lastUpdateBy;
}