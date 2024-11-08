package com.conurets.parking_kiosk.base.exception;

import com.conurets.parking_kiosk.base.dto.response.BaseResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
@ControllerAdvice
public class PKExceptionHandler {
    /**
     * ParkERPException
     *
     * @param e
     * @return BaseResponseDTO
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(PKException.class)
    public BaseResponseDTO handleHCM(PKException e) {
        return response(e.getCode(), e.getMessage(), e);
    }

    /**
     * ResultNotFoundException
     *
     * @param e
     * @return BaseResponseDTO
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ResultNotFoundException.class)
    public BaseResponseDTO handleResultNotFound(ResultNotFoundException e) {
        return response(e.getCode(), e.getMessage(), e);
    }

    /**
     * InvalidDataException
     *
     * @param e
     * @return BaseResponseDTO
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InvalidDataException.class)
    public BaseResponseDTO handleInvalidData(InvalidDataException e) {
        return response(e.getCode(), e.getMessage(), e);
    }

    /**
     * ConfigurationException
     *
     * @param e
     * @return BaseResponseDTO
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ConfigurationException.class)
    public BaseResponseDTO handleConfiguration(ConfigurationException e) {
        return response(e.getCode(), e.getMessage(), e);
    }

    /**
     * TransactionException
     *
     * @param e
     * @return BaseResponseDTO
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TransactionException.class)
    public BaseResponseDTO handleTransaction(TransactionException e) {
        return response(e.getCode(), e.getMessage(), e);
    }

    /**
     * RefundException
     *
     * @param e
     * @return BaseResponseDTO
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RefundException.class)
    public BaseResponseDTO handleRefund(RefundException e) {
        return response(e.getCode(), e.getMessage(), e);
    }

    /**
     * TransactionException
     *
     * @param e
     * @return BaseResponseDTO
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(JwtException.class)
    public BaseResponseDTO handleJwt(JwtException e) {
        return response(e.getCode(), e.getMessage(), e);
    }

    /**
     * BaseResponseDTO
     *
     * @param code
     * @param value
     * @return BaseResponseDTO
     */
    private BaseResponseDTO response(int code, String value) {
        BaseResponseDTO response = new BaseResponseDTO();
        response.setCode(code);
        response.setValue(value);

        return response;
    }

    /**
     * BaseResponseDTO
     *
     * @param code
     * @param value
     * @param e
     * @return BaseResponseDTO
     */
    private BaseResponseDTO response(int code, String value, Throwable e) {
        log.error("error", e);

        return response(code, value);
    }
}
