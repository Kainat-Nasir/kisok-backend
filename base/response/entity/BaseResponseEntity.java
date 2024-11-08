package com.conurets.parking_kiosk.base.response.entity;

import com.conurets.parking_kiosk.base.dto.response.BaseResponseDTO;
import com.conurets.parking_kiosk.base.util.PKStatusConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
public abstract class BaseResponseEntity {
    /**
     * Set base response
     *
     * @return ResponseEntity<BaseResponseDTO>
     */
    public BaseResponseDTO response() {
        return response(PKStatusConstants.STATUS_CODE_SUCCESS, PKStatusConstants.STATUS_MSG_SUCCESS, null);
    }

    /**
     * Set base response
     *
     * @param code
     * @param value
     * @return ResponseEntity<BaseResponseDTO>
     */
    public BaseResponseDTO response(int code, String value) {
        return response(code, value, null);
    }

    /**
     * Set base response
     *
     * @param data
     * @param <R>
     * @return ResponseEntity<BaseResponseDTO>
     */
    public <R> BaseResponseDTO response(R data) {
        return response(PKStatusConstants.STATUS_CODE_SUCCESS, PKStatusConstants.STATUS_MSG_SUCCESS, data);
    }

    /**
     * Set base response
     *
     * @param code
     * @param value
     * @param data
     * @param <R>
     * @return ResponseEntity<BaseResponseDTO>
     */
    public <R> BaseResponseDTO response(int code, String value, R data) {
        BaseResponseDTO<R> baseResponseDTO = new BaseResponseDTO<R>();
        baseResponseDTO.setCode(code);
        baseResponseDTO.setValue(value);
        baseResponseDTO.setData(data);

        return baseResponseDTO;
    }

    /**
     * Set base response
     *
     * @param code
     * @param value
     * @param data
     * @param <R>
     * @return ResponseEntity<BaseResponseDTO>
     */
    public <R> BaseResponseDTO response(HttpStatus code, String value, R data) {
        BaseResponseDTO<R> baseResponseDTO = new BaseResponseDTO<R>();
        baseResponseDTO.setCode(code.value());
        baseResponseDTO.setValue(value);
        baseResponseDTO.setData(data);

        return baseResponseDTO;
    }

    /**
     * Set base response
     *
     * @param code
     * @param value
     * @return ResponseEntity<BaseResponseDTO>
     */
    public BaseResponseDTO response(HttpStatus code, String value) {
        return response(code, value, null);
    }
}
