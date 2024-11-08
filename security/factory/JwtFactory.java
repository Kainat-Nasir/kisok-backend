package com.conurets.parking_kiosk.security.factory;

import com.conurets.parking_kiosk.base.cache.PreferenceCache;
import com.conurets.parking_kiosk.base.util.*;
import com.conurets.parking_kiosk.persistence.entity.Preference;
import com.conurets.parking_kiosk.persistence.repository.PreferenceRepository;
import com.conurets.parking_kiosk.security.model.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.security.Key;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
@Component
public class JwtFactory implements Serializable {
    @Autowired
    PreferenceRepository preferenceRepository;
    /**
     * getUsernameFromToken
     *
     * @param token
     * @return String
     */
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * getExpirationDateFromToken
     *
     * @param token
     * @return Date
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * getClaimFromToken
     *
     * @param token
     * @param claimsResolver
     * @param <T>
     * @return <T> T
     */
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);

        return claimsResolver.apply(claims);
    }

    /**
     * getAllClaimsFromToken
     *
     * @param token
     * @return Claims
     */
    private Claims getAllClaimsFromToken(String token) {
        String secret = PreferenceCache.getProperty(APConstants.JWT_SECRET);
        Key key = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    /**
     * isTokenExpired
     *
     * @param token
     * @return Boolean
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);

        return expiration.before(PKDateUtil.getCurrentDate());
    }

    /**
     * generateToken
     *
     * @param userDetails
     * @return String
     */
    public String generateToken(CustomUserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        return generateToken(claims, userDetails.getUsername());
    }

    /**
     * generateToken
     *
     * @param claims
     * @param subject
     * @return String
     */
    private String generateToken(Map<String, Object> claims, String subject) {
//------------Task id : 1414 ---------------
        String strSecret = PreferenceCache.getProperty(APConstants.JWT_SECRET);
        if (Objects.isNull(strSecret)) {
            List<Preference> preferences = preferenceRepository.findAll();
            if (PKUtil.isCollectionNotBlank(preferences)) {
                preferences.stream().map(PreferenceCache::setCache).collect(Collectors.toList());
            }
            strSecret = PreferenceCache.getProperty(APConstants.JWT_SECRET);
        }
        int iExpiration = PKUtil.stringToInteger(PreferenceCache.getProperty(APConstants.JWT_EXPIRATION));
        String strIssuer = PreferenceCache.getProperty(APConstants.JWT_ISSUER);
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expirationDate = new Date(System.currentTimeMillis() + iExpiration * 1000);
        Key key = Keys.hmacShaKeyFor(strSecret.getBytes());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(issuedAt)
                .setExpiration(expirationDate)
                .setIssuer(strIssuer)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
}

    /**
     * validateToken
     *
     * @param token
     * @param userDetails
     * @return Boolean
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
