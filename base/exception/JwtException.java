package com.conurets.parking_kiosk.base.exception;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class JwtException extends BasePKException {
    public JwtException(String message) {
        super(message);
    }

    public JwtException(int code, String message) {
        super(code, message);
    }

    public JwtException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
