package com.conurets.parking_kiosk.base.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponseDTO<R> implements Serializable {
    private int code;
    private String value;
    private R data;
    private  List<R> dataList;
    private int page;
    private long totalRecords;
    public BaseResponseDTO(HttpStatus status, String message, R data,int page, long totalRecords) {
        this.code = status.value();
        this.value = message;
        this.data = data;
        this.page = page;
        this.totalRecords = totalRecords;
    }
    public  BaseResponseDTO(HttpStatus status, String message, List<R> dataList){
        this.code = status.value();
        this.value = message;
        this.dataList=dataList;

    }
    public BaseResponseDTO(HttpStatus status, String message) {
        this.code = status.value();
        this.value = message;
    }
    public BaseResponseDTO(HttpStatus status, String message, R data) {
        this.code = status.value();
        this.value = message;
        this.data = data;
    }
    public BaseResponseDTO() {
    }
}
