package com.conurets.parking_kiosk.base.dto.response;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BaseResponse {
    private  Long id;
    private Integer status;
    private Timestamp createdDate;
    private Long createdBy;
    private Timestamp lastUpdate;
    private Long lastUpdateBy;

}
