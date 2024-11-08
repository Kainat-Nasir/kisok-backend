package com.conurets.parking_kiosk.security.exception;

import com.conurets.parking_kiosk.base.util.PKMessageUtil;
import com.conurets.parking_kiosk.base.util.PKStatusConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    @Autowired
    private PKMessageUtil messageUtil;

    /**
     * commence
     *
     * @param request
     * @param response
     * @param e
     * @throws IOException
     */
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        String uri = request.getRequestURI();

        log.info("=================================================================================================");
        log.info("CustomAuthenticationEntryPoint.commence start");
        log.info("=================================================================================================");
        log.info("CustomAuthenticationEntryPoint.commence message={}", e.getMessage());
        log.info("CustomAuthenticationEntryPoint.commence uri={}", uri);

        if (PKStatusConstants.STATUS_MSG_INVALID_CREDENTIALS.equals(e.getMessage())) {
            PKMessageUtil.setJwtErrorResponse(response, PKStatusConstants.STATUS_CODE_NO_USER_FOUND, "No user found");
        } else if (PKStatusConstants.STATUS_MSG_FULL_AUTHENTICATION_REQUIRED.equals(e.getMessage())) {
            PKMessageUtil.setJwtErrorResponse(response, PKStatusConstants.STATUS_CODE_FULL_AUTHENTICATION_REQUIRED, "Invalid access");
        } else {
            if (e.getMessage() == null) {
                PKMessageUtil.setJwtErrorResponse(response, PKStatusConstants.STATUS_CODE_INVALID_CREDENTIALS, "Invalid credentials");
            } else {
                PKMessageUtil.setJwtErrorResponse(response, PKStatusConstants.STATUS_CODE_INVALID_TOKEN, "Invalid token");
            }
        }

        log.info("=================================================================================================");
    }
}
