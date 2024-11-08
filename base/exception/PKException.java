package com.conurets.parking_kiosk.base.exception;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class PKException extends BasePKException {
    public PKException(String message) {
        super(message);
    }

    public PKException(int code, String message) {
        super(code, message);
    }

    public PKException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}