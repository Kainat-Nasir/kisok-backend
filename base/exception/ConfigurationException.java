package com.conurets.parking_kiosk.base.exception;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class ConfigurationException extends BasePKException {
    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(int code, String message) {
        super(code, message);
    }

    public ConfigurationException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}