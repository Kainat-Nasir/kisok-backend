package com.conurets.parking_kiosk.base.exception;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class RefundException extends BasePKException {
    public RefundException(String message) {
        super(message);
    }

    public RefundException(int code, String message) {
        super(code, message);
    }

    public RefundException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}