package com.conurets.parking_kiosk.base.exception;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class ResultNotFoundException extends BasePKException {
    public ResultNotFoundException(String message) {
        super(message);
    }

    public ResultNotFoundException(int code, String message) {
        super(code, message);
    }

    public ResultNotFoundException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}