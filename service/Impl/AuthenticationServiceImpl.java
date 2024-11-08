package com.conurets.parking_kiosk.service.Impl;

import com.conurets.parking_kiosk.base.dto.request.AuthenticationRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.AuthenticationResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.mapper.AuthenticationMapper;
import com.conurets.parking_kiosk.persistence.entity.RoleMenu;
import com.conurets.parking_kiosk.persistence.entity.UserRole;
import com.conurets.parking_kiosk.persistence.repository.RoleMenuRepository;
import com.conurets.parking_kiosk.persistence.repository.UserRoleRepository;
import com.conurets.parking_kiosk.security.factory.JwtFactory;
import com.conurets.parking_kiosk.security.model.CustomUserDetails;
import com.conurets.parking_kiosk.security.util.PKSecurityUtil;
import com.conurets.parking_kiosk.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
@Service
public class AuthenticationServiceImpl extends BaseServiceImpl implements AuthenticationService {
    /**
     * Authentication and authorization
     *
     * @param model
     * @return AuthenticationResponseDTO
     * @throws PKException
     */
    AuthenticationMapper authenticationMapper;
    UserRoleRepository userRoleRepository;
    RoleMenuRepository roleMenuRepository;
    JwtFactory jwtFactory;

    public AuthenticationServiceImpl(AuthenticationMapper authenticationMapper, UserRoleRepository userRoleRepository, RoleMenuRepository roleMenuRepository, JwtFactory jwtFactory) {
        this.authenticationMapper = authenticationMapper;
        this.userRoleRepository = userRoleRepository;
        this.roleMenuRepository = roleMenuRepository;
        this.jwtFactory = jwtFactory;
    }

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO model) throws PKException {
        final Authentication authentication = getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(model.getEmailAddress(), model.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        CustomUserDetails customUserDetails = PKSecurityUtil.getUserDetails();

        final String accessToken = this.jwtFactory.generateToken(customUserDetails);

        Optional<UserRole> userRole = this.userRoleRepository.findByUserId(customUserDetails.getUserId());
        List<RoleMenu> menuPrivileges = this.roleMenuRepository.findByMenuParentMenuIsNullAndRoleId(userRole.get().getRole().getId());
        return this.authenticationMapper.authenticate(customUserDetails,menuPrivileges,accessToken);
    }

    /**
     * Logout
     *
     * @throws PKException
     */
    public void logout() throws PKException {
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
