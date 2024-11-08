package com.conurets.parking_kiosk.security.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * handle
     *
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    public void handle(HttpServletRequest request, HttpServletResponse
            response, AccessDeniedException e)
            throws IOException, ServletException {
        log.info("=================================================================================================");
        log.info("CustomAccessDeniedHandler.handle start");
        log.info("=================================================================================================");
        log.info("CustomAccessDeniedHandler.handle message={}", e.getMessage());

        response.sendError(HttpServletResponse.SC_PROXY_AUTHENTICATION_REQUIRED, "Access is denied");

        log.info("=================================================================================================");
    }
}
