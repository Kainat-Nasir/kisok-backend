package com.conurets.parking_kiosk.security.model;

import com.conurets.parking_kiosk.base.util.PKConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class CustomUserDetails implements UserDetails {
    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String role;
    private String userType;
    private Long userTypeId;
    private List<SecurityPrivilege> securityPrivileges;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private Boolean isAccountNonExpired;
    @JsonIgnore
    private Boolean isAccountNonLocked;
    @JsonIgnore
    private Boolean isCredentialsNonExpired;
    @JsonIgnore
    private Boolean isEnabled;
    @JsonIgnore
    private List<GrantedAuthority> authorities;

    public CustomUserDetails() {
    }

    public CustomUserDetails(Long userId, String firstName, String lastName, String username, String password,
                             String role,  List<SecurityPrivilege> securityPrivileges,
                             List<GrantedAuthority> authorities) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.securityPrivileges = securityPrivileges;
        this.isAccountNonExpired = Boolean.TRUE;
        this.isAccountNonLocked = Boolean.TRUE;
        this.isCredentialsNonExpired = Boolean.TRUE;
        this.isEnabled = Boolean.TRUE;
        this.authorities = authorities;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDisplayName() {
        return firstName + PKConstants.Common.SC_SPACE + lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getUserType() {
        return userType;
    }

    public Long getUserTypeId() {
        return userTypeId;
    }

    public List<SecurityPrivilege> getSecurityPrivileges() {
        return securityPrivileges;
    }

    @JsonIgnore
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @JsonIgnore
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @JsonIgnore
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public void setSecurityPrivileges(List<SecurityPrivilege> securityPrivileges) {
        this.securityPrivileges = securityPrivileges;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}