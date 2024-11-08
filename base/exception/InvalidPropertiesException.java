package com.conurets.parking_kiosk.base.exception;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class InvalidPropertiesException extends BasePKException {
    public InvalidPropertiesException(String message) {
        super(message);
    }

    public InvalidPropertiesException(int code, String message) {
        super(code, message);
    }

    public InvalidPropertiesException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}