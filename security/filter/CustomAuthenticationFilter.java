package com.conurets.parking_kiosk.security.filter;

import com.conurets.parking_kiosk.base.exception.JwtException;
import com.conurets.parking_kiosk.base.util.PKConstants;
import com.conurets.parking_kiosk.base.util.PKHelper;
import com.conurets.parking_kiosk.base.util.PKMessageUtil;
import com.conurets.parking_kiosk.security.authentication.CustomAuthentication;
import com.conurets.parking_kiosk.security.util.PKSecurityUtil;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private CustomAuthentication customAuthentication;
    @Autowired
    private PKMessageUtil messageUtil;

    @PostConstruct
    public void checkConfiguration() {
        PKHelper.checkConfiguration(customAuthentication, "customAuthentication");
        PKHelper.checkConfiguration(messageUtil, "messageUtil");
    }

    /**
     * doFilterInternal
     *
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        try {
            //log.info("base64Credentials={}", FLSecurityUtil.getBasic(request));

            final String authorizationType = PKSecurityUtil.getAuthorizationType(request);

            //log.info("authorizationType={}", authorizationType);

            if (PKConstants.Header.AUTHORIZATION_BEARER.equals(authorizationType)) {
                    final String token = PKSecurityUtil.getJwt(request);

                //log.info("token={}", token);

                customAuthentication.authenticationByToken(token);
            } else if (PKConstants.Header.AUTHORIZATION_BASIC.equals(authorizationType)) {
                final String base64Credentials = PKSecurityUtil.getBasic(request);

                //log.info("base64Credentials={}", base64Credentials);

                byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
                String credentials = new String(credDecoded, StandardCharsets.UTF_8);
                // credentials = username:password
                final String[] values = credentials.split(PKConstants.Common.SC_COLON, PKConstants.Common.INT_TWO);

                //log.info("u={}, p={}", values[FLConstants.INT_ZERO].toString(), values[FLConstants.INT_ONE].toString());

                customAuthentication.authenticationByUser(values[PKConstants.Common.INT_ZERO],
                        values[PKConstants.Common.INT_ONE], request);
            }

            chain.doFilter(request, response);
        } catch (JwtException e) {
            PKMessageUtil.setJwtErrorResponse(response, e.getCode(), e.getMessage());
        }
    }
}
