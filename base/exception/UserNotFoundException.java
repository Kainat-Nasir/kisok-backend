package com.conurets.parking_kiosk.base.exception;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class UserNotFoundException extends BasePKException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(int code, String message) {
        super(code, message);
    }

    public UserNotFoundException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}