package com.conurets.parking_kiosk.security.authentication;


import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.PKConstants;
import com.conurets.parking_kiosk.base.util.PKHelper;
import com.conurets.parking_kiosk.base.util.PKStatusConstants;
import com.conurets.parking_kiosk.security.factory.JwtFactory;
import com.conurets.parking_kiosk.security.service.CustomUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;


/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
@Component
public class CustomAuthentication {
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtFactory jwtFactory;

    @Autowired
    public CustomAuthentication(CustomUserDetailsService customUserDetailsService, JwtFactory jwtFactory) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtFactory = jwtFactory;
    }
    @PostConstruct
    public void checkConfiguration() {
        PKHelper.checkConfiguration(customUserDetailsService, "customUserDetailsService");
        PKHelper.checkConfiguration(jwtFactory, "jwtFactory");
    }

    /**
     * authenticationByToken
     *
     * @param token
     * @throws PKException
     */
    public void authenticationByToken(String token) throws PKException {
        String username = PKConstants.Common.SC_EMPTY;

        if (token == null) {
            PKHelper.handleJwt(PKStatusConstants.STATUS_CODE_JWT_INVALID_SIGNATURE, "Empty token");
        }

        try {
            username = jwtFactory.getUsernameFromToken(token);
        } catch (SignatureException e) {
            PKHelper.handleJwt(PKStatusConstants.STATUS_CODE_JWT_INVALID_SIGNATURE, e.getMessage());
        } catch (MalformedJwtException e) {
            PKHelper.handleJwt(PKStatusConstants.STATUS_CODE_JWT_MALFORMED, e.getMessage());
        } catch (ExpiredJwtException e) {
            PKHelper.handleJwt(PKStatusConstants.STATUS_CODE_JWT_EXPIRED, e.getMessage());
        } catch (UnsupportedJwtException e) {
            PKHelper.handleJwt(PKStatusConstants.STATUS_CODE_JWT_UNSUPPORTED, e.getMessage());
        } catch (IllegalArgumentException e) {
            PKHelper.handleJwt(PKStatusConstants.STATUS_CODE_JWT_ILLEGAL_ARGUMENT, e.getMessage());
        }

        authenticationByToken(token, username);
    }

    /**
     * authenticationByToken
     *
     * @param token
     * @param username
     * @throws PKException
     */
    public void authenticationByToken(String token, String username) throws PKException {
        UsernamePasswordAuthenticationToken authentication = null;

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

        if (jwtFactory.validateToken(token, userDetails)) {
            authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                    userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    /**
     * authenticationByUser
     *
     * @param username
     * @param request
     * @throws PKException
     */
    public void authenticationByUser(String username, String password, HttpServletRequest request) throws PKException {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

        boolean isMatched = false; //passwordEncoder.matches(password, userDetails.getPassword());

        //log.info("isMatched={}", isMatched);

        if (!isMatched) {
            PKHelper.handleAuthentication(9901, "Invalid credentials");
        }

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
                null, userDetails.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
