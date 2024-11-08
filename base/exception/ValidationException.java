package com.conurets.parking_kiosk.base.exception;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class ValidationException extends BasePKException {
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(int code, String message) {
        super(code, message);
    }

    public ValidationException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
