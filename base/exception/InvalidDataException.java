package com.conurets.parking_kiosk.base.exception;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class InvalidDataException extends BasePKException {
    public InvalidDataException(String message) {
        super(message);
    }

    public InvalidDataException(int code, String message) {
        super(code, message);
    }

    public InvalidDataException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}