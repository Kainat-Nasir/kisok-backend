package com.conurets.parking_kiosk.base.exception;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class OtpException extends BasePKException {
    public OtpException(String message) {
        super(message);
    }

    public OtpException(int code, String message) {
        super(code, message);
    }

    public OtpException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}