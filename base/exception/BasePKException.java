package com.conurets.parking_kiosk.base.exception;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class BasePKException extends RuntimeException {
    private int code;

    public BasePKException(String message) {
        super(message);
    }

    public BasePKException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BasePKException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public final int getCode() {
        return this.code;
    }

    public String getMessage() {
        return super.getMessage();
    }
}