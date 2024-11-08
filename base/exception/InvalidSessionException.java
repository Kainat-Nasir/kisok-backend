package com.conurets.parking_kiosk.base.exception;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class InvalidSessionException extends BasePKException {
    public InvalidSessionException(String message) {
        super(message);
    }

    public InvalidSessionException(int code, String message) {
        super(code, message);
    }

    public InvalidSessionException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}