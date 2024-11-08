package com.conurets.parking_kiosk.base.util;

import com.conurets.parking_kiosk.base.dto.response.BaseErrorResponseDTO;
import com.conurets.parking_kiosk.base.exception.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Locale;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
@Component
public class PKMessageUtil {
    @Autowired
    private MessageSource messageSource;

    /**
     * @param response
     * @param code
     * @param message
     * @throws IOException
     */
    public static void setJwtErrorResponse(HttpServletResponse response, int code, String message) throws IOException {
        BaseErrorResponseDTO baseErrorResponseDTO = setBaseErrorResponse(code, message);

        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.getWriter().write(PKUtil.writeValue(baseErrorResponseDTO));
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    }

    /**
     * @param code
     * @param value
     * @param <R>
     * @return
     */
    public static BaseErrorResponseDTO setBaseErrorResponse(int code, String value) {
        BaseErrorResponseDTO response = new BaseErrorResponseDTO();
        response.setCode(code);
        response.setValue(value);

        return response;
    }

    /**
     * @param code
     * @throws PKException
     */
    public void handleBase(int code) throws PKException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        throw new PKException(code, message);
    }

    /**
     * @param response
     * @param code
     * @throws IOException
     */
    public void handleBase(HttpServletResponse response, int code) throws IOException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        message(response, code, message);
    }

    /**
     * @param code
     * @throws PKException
     */
    public void handleSessionExpired(int code) throws PKException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        throw new InvalidSessionException(code, message);
    }

    /**
     * @param code
     * @throws PKException
     */
    public void handleNoResultFound(int code) throws PKException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        throw new ResultNotFoundException(code, message);
    }

    /**
     * @param code
     * @throws PKException
     */
    public void handleJwt(int code) throws PKException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        throw new JwtException(code, message);
    }

    /**
     * @param code
     * @throws PKException
     */
    public void handleValidation(int code) throws PKException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        throw new ValidationException(code, message);
    }

    /**
     * @param response
     * @param code
     * @throws IOException
     */
    public void handleAuthenticationException(HttpServletResponse response, int code) throws IOException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        message(response, code, message, HttpStatus.UNAUTHORIZED.value());
    }

    /**
     * @param response
     * @param code
     * @throws IOException
     */
    public void handleAccessDeniedException(HttpServletResponse response, int code) throws IOException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        message(response, code, message);
    }

    /**
     * @param response
     * @param code
     * @param message
     * @throws IOException
     */
    private void message(HttpServletResponse response, int code, String message) throws IOException {
        BaseErrorResponseDTO baseErrorResponseDTO = setBaseErrorResponse(code, message);

        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write(PKUtil.writeValue(baseErrorResponseDTO));
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    }

    /**
     * @param response
     * @param code
     * @param message
     * @param statusCode
     * @throws IOException
     */
    private void message(HttpServletResponse response, int code, String message, int statusCode) throws IOException {
        BaseErrorResponseDTO baseErrorResponseDTO = setBaseErrorResponse(code, message);

        response.setStatus((statusCode == PKStatusConstants.STATUS_CODE_SUCCESS) ? HttpStatus.OK.value() : statusCode);
        response.getWriter().write(PKUtil.writeValue(baseErrorResponseDTO));
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    }
}
