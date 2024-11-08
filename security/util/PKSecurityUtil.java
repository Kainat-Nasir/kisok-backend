package com.conurets.parking_kiosk.security.util;

import com.conurets.parking_kiosk.base.util.PKConstants;
import com.conurets.parking_kiosk.security.model.CustomUserDetails;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
public class PKSecurityUtil {

    public static String ACCESS_TOKEN = null;

    public static void main(String[] args) {
        //System.out.println(generatePassword("test123"));

        //boolean is = new BCryptPasswordEncoder().matches("superadmin", "$2a$10$9/K2knY/Dclz3.BQzULKYejzYkNuclVP.mCASks.5fsjgOk6IMgJy");

        //log.info("is={}", is);

        //log.info("encode={}", FLUtil.encode("cts.gateway.user:test123"));
        //log.info("encode={}", ParkERPUtil.encode("cts.gateway.user:test123"));
    }

    /**
     * Create auto password
     *
     * @param length
     * @return String
     */
    public static String createAutoPassword(int length) {
        char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
                'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3',
                '4', '5', '6', '7', '8', '9', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        int range = alphabet.length;
        Random r = new Random();
        StringBuffer sb = new StringBuffer(length);

        for (int i = PKConstants.Common.INT_ZERO; i < length; i++) {
            sb.append(alphabet[r.nextInt(range)]);
        }

        return sb.toString();
    }

    public static boolean validateEmail(String email) {
        String lowerEmail = email.toLowerCase();

        if (lowerEmail.contains("<script>") || lowerEmail.contains("</script>")) {
            return false;
        }

        String email_pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(lowerEmail);
        return matcher.matches();
    }

    /**
     * Create OTP
     *
     * @param length
     * @return String
     */
    public static String createOTP(int length) {
        char[] alphabet = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        int range = alphabet.length;
        Random r = new Random();
        StringBuffer sb = new StringBuffer(length);

        for (int i = PKConstants.Common.INT_ZERO; i < length; i++) {
            sb.append(alphabet[r.nextInt(range)]);
        }

        return sb.toString();
    }

    public static Date createOTPExpiry(int minsToExpire) {
        Calendar date = Calendar.getInstance();
        long timeInSecs = date.getTimeInMillis();
        Date expiry = new Date(timeInSecs + (minsToExpire * 60 * 1000));

        return expiry;
    }

    /**
     * Get logged in user id
     *
     * @return long
     */
    public static long getLoggedInUserId() {
        return (getUserDetails() == null) ? PKConstants.Common.DEFAULT_USER_ID : getUserDetails().getUserId();
    }

//    public static int getLoggedInUserOrgId() {
//        return (getUserDetails() == null) ? PKConstants.DEFAULT_USER_ID
//                : getUserDetails().getOrganizationId();
//    }

    /**
     * Get logged in user type id
     *
     * @return long
     */
    public static long getLoggedInUserTypeId() {
        return (getUserDetails() == null) ? PKConstants.Common.DEFAULT_USER_ID : getUserDetails().getUserTypeId();
    }

    public static String getLoggedInUserTypeName() {
        return (getUserDetails() == null) ? "" : getUserDetails().getUserType();
    }


    /**
     * Get logged in user name
     *
     * @return String
     */
    public static String getLoggedInUsername() {
        return (getUserDetails() == null) ? PKConstants.Common.SC_EMPTY : getUserDetails().getUsername();
    }

    /**
     * Get logged in user full name
     *
     * @return String
     */
    public static String getLoggedInFullName() {
        return (getUserDetails() == null) ? PKConstants.Common.SC_EMPTY : getUserDetails().getDisplayName();
    }

    /**
     * Get logged in user role
     *
     * @return
     */
    public static String getUserRole() {
        return getUserDetails().getRole();
    }

    /**
     * Generate password
     *
     * @param input
     * @return String
     */
    public static String generatePassword(String input) {
        return new BCryptPasswordEncoder(PKConstants.Common.INT_TWELVE).encode(input);
    }

    /**
     * validatePassword
     *
     * @param userRequest
     * @param databaseResponse
     * @return Boolean
     */
    public static Boolean validatePassword(String userRequest, String databaseResponse) {
        return new BCryptPasswordEncoder().matches(userRequest, databaseResponse);
    }

    /**
     * Get logged in user detail
     *
     * @return CustomUserDetails
     */
    public static CustomUserDetails getUserDetails() {
        CustomUserDetails customUserDetails = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
            customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        }

        return customUserDetails;
    }

    /**
     * getJwt
     *
     * @param request
     * @return String
     */
    public static String getJwt(HttpServletRequest request) {
        String authHeader = request.getHeader(PKConstants.Header.AUTHORIZATION);

        if (authHeader != null && authHeader.startsWith(PKConstants.Header.AUTHORIZATION_BEARER_SPACE)) {
            return authHeader.replace(PKConstants.Header.AUTHORIZATION_BEARER_SPACE, PKConstants.Common.SC_EMPTY);
        }

        return null;
    }

    /**
     * getBasic
     *
     * @param request
     * @return String
     */
    public static String getBasic(HttpServletRequest request) {
        String authHeader = request.getHeader(PKConstants.Header.AUTHORIZATION);

        if (authHeader != null && authHeader.startsWith(PKConstants.Header.AUTHORIZATION_BASIC_SPACE)) {
            return authHeader.replace(PKConstants.Header.AUTHORIZATION_BASIC_SPACE, PKConstants.Common.SC_EMPTY);
        }

        return null;
    }

    /**
     * getAuthorizationType
     *
     * @param request
     * @return String
     */
    public static String getAuthorizationType(HttpServletRequest request) {
        String authorizationType = PKConstants.Common.SC_EMPTY;
        String authorizationHeader = request.getHeader(PKConstants.Header.AUTHORIZATION);

        if (authorizationHeader != null && authorizationHeader.startsWith(PKConstants.Header.AUTHORIZATION_BEARER_SPACE)) {
            authorizationType = PKConstants.Header.AUTHORIZATION_BEARER;
        } else if (authorizationHeader != null && authorizationHeader.startsWith(PKConstants.Header.AUTHORIZATION_BASIC_SPACE)) {
            authorizationType = PKConstants.Header.AUTHORIZATION_BASIC;
        }

        return authorizationType;
    }

}
