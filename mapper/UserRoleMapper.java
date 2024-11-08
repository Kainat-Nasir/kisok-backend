package com.conurets.parking_kiosk.mapper;

import com.conurets.parking_kiosk.base.dto.response.RoleResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.Role;
import com.conurets.parking_kiosk.persistence.entity.User;
import com.conurets.parking_kiosk.persistence.entity.UserRole;
import org.springframework.stereotype.Component;

@Component
public class UserRoleMapper extends BaseMapper{
    public UserRole add(Role role, User user) throws PKException{
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userRole.setStatus(1);
        addAuditingInformation(userRole);
        return userRole;
    }

    public UserRole update(Role role, User user, Integer status) throws PKException{
        UserRole userRole = roleRepository.findByUserId(user.getId()).get();
        userRole.setRole(role);
        userRole.setUser(user);
        userRole.setStatus(status);
        addAuditingInformation(userRole);
        return userRole;
    }

    public RoleResponseDTO find(Role role) throws PKException{
        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();

        roleResponseDTO.setId(role.getId());
        roleResponseDTO.setRoleDescription(role.getDescription());
        roleResponseDTO.setRoleName(role.getName());
        roleResponseDTO.setStatus(role.getStatus());
        return roleResponseDTO;
    }


}
