package com.conurets.parking_kiosk.base.util;

import com.conurets.parking_kiosk.base.exception.*;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class PKHelper {
    /**
     * Check Configuration
     *
     * @param object
     * @param value
     */
    public static void checkConfiguration(Object object, String value) {
        if (object == null) {
            throw new ConfigurationException(9999, value);
        }
    }

    /**
     * Handle ResultNotFound
     *
     * @param object
     * @param code
     * @param message
     */
    public static void handleResultNotFound(Object object, int code, String message) {
        if (object == null) {
            throw new ResultNotFoundException(code, message);
        }
    }

    /**
     * Handle ResultNotFound
     *
     * @param code
     * @param message
     */
    public static void handleResultNotFound(int code, String message) {
        throw new ResultNotFoundException(code, message);
    }

    /**
     * Handle Transaction
     *
     * @param code
     * @param message
     */
    public static void handleTransaction(int code, String message) {
        throw new TransactionException(code, message);
    }

    /**
     * Handle Refund
     *
     * @param code
     * @param message
     */
    public static void handleRefund(int code, String message) {
        throw new RefundException(code, message);
    }

    public static void handleOtp(int code, String message) {
        throw new OtpException(code, message);
    }

    /**
     * Handle UserNotFound
     *
     * @param object
     * @param code
     * @param message
     */
    public static void handleUserNotFound(Object object, int code, String message) {
        if (object == null) {
            throw new UserNotFoundException(code, message);
        }
    }

    /**
     * Handle UserNotFound
     *
     * @param code
     * @param message
     */
    public static void handleUserNotFound(int code, String message) {
        throw new UserNotFoundException(code, message);
    }

    /**
     * Handle Jwt
     *
     * @param code
     * @param message
     */
    public static void handleJwt(int code, String message) {
        throw new JwtException(code, message);
    }

    /**
     * Authentication exception
     *
     * @param code
     * @param message
     */
    public static void handleAuthentication(int code, String message) {
        throw new JwtException(code, message);
    }
}