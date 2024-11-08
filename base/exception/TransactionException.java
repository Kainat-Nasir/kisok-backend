package com.conurets.parking_kiosk.base.exception;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class TransactionException extends BasePKException {
    public TransactionException(String message) {
        super(message);
    }

    public TransactionException(int code, String message) {
        super(code, message);
    }

    public TransactionException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}