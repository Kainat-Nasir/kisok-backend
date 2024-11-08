package com.conurets.parking_kiosk.base.exception;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class EntityNotFoundException extends BasePKException {
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(int code, String message) {
        super(code, message);
    }

    public EntityNotFoundException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}