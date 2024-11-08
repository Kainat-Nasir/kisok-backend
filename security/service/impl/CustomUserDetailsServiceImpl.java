package com.conurets.parking_kiosk.security.service.impl;

import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.PKConstants;
import com.conurets.parking_kiosk.base.util.PKHelper;
import com.conurets.parking_kiosk.base.util.PKStatusConstants;
import com.conurets.parking_kiosk.base.util.PKUtil;
import com.conurets.parking_kiosk.persistence.entity.*;
import com.conurets.parking_kiosk.persistence.repository.*;
import com.conurets.parking_kiosk.security.model.CustomUserDetails;
import com.conurets.parking_kiosk.security.model.SecurityPrivilege;
import com.conurets.parking_kiosk.security.service.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
    private  UserRepository userRepository;
    private UserLoginRepository userLoginRepository;
    private UserRoleRepository  userRoleRepository;

    @Autowired
    public CustomUserDetailsServiceImpl(UserRepository userRepository, UserLoginRepository userLoginRepository,
                                        UserRoleRepository  userRoleRepository
                                        ) {
        this.userRepository = userRepository;
        this.userLoginRepository = userLoginRepository;
        this.userRoleRepository=userRoleRepository;

    }

    public CustomUserDetailsServiceImpl() {

    }

    /**
     * loadUserByUsername
     *
     * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SecurityPrivilege> securityPrivileges = new ArrayList<>();
        List<GrantedAuthority> authorities = new ArrayList<>();

        Optional<User> user = userRepository.findByEmailAddress(username);

        if (user.isEmpty()) {
            PKHelper.handleResultNotFound(PKStatusConstants.STATUS_CODE_NO_USER_FOUND, PKStatusConstants.STATUS_MSG_NO_USER_FOUND);
        }

        if (user.get().getStatus() == PKConstants.Common.STATUS_CODE_INACTIVE) {
            PKHelper.handleResultNotFound(PKStatusConstants.STATUS_CODE_INACTIVE_USER, PKStatusConstants.STATUS_MSG_INACTIVE_USER);
        }

        if (user.get().getStatus() == PKConstants.Common.STATUS_CODE_DELETE) {
            PKHelper.handleResultNotFound(PKStatusConstants.STATUS_CODE_USER_DELETED, PKStatusConstants.STATUS_MSG_USER_DELETED);
        }

        Optional<UserLogin> userCredential = userLoginRepository.findByUserId(user.get().getId());

        if (userCredential.isEmpty()) {
            PKHelper.handleResultNotFound(PKStatusConstants.STATUS_CODE_NO_CREDENTIAL_FOUND, PKStatusConstants.STATUS_MSG_NO_CREDENTIAL_FOUND);
        }

        List<UserRole> userRoles = userRoleRepository.findAllByUserId(userCredential.get().getUser().getId());

        if (!PKUtil.isCollectionNotBlank(userRoles)) {
            PKHelper.handleResultNotFound(PKStatusConstants.STATUS_CODE_NO_USER_ROLE_FOUND, PKStatusConstants.STATUS_MSG_NO_USER_ROLE_FOUND);
        }

        // Multiple role handler
        UserRole userRole = userRoles.get(PKConstants.Common.INT_ZERO);

        if (userRole != null) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" +userRole.getRole().getName());
            authorities.add(simpleGrantedAuthority);
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(user.get().getId(), user.get().getFirstName(), user.get().getLastName(),
                user.get().getEmailAddress(), userCredential.get().getCredential(), userRole.getRole().getName(),
                securityPrivileges, authorities);

        return customUserDetails;
    }

    /**
     * setSecurityPrivilege
     *
     * @param privilegeName
     * @param readOnly
     * @return SecurityPrivilege
     */
    public SecurityPrivilege setSecurityPrivilege(String privilegeName, boolean readOnly) throws PKException {
        return SecurityPrivilege.builder()
                .privilegeName(privilegeName)
                .readOnly(readOnly)
                .build();
    }
}
