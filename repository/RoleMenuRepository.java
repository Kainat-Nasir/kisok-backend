package com.conurets.parking_kiosk.persistence.repository;

import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.Menu;
import com.conurets.parking_kiosk.persistence.entity.Role;
import com.conurets.parking_kiosk.persistence.entity.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Repository
public interface RoleMenuRepository extends JpaRepository<RoleMenu, Long> {
    List<RoleMenu> findByMenuParentMenuIsNullAndRoleId(Long privilegeId) throws PKException;
    Optional<RoleMenu> findByMenuIdAndRoleId(Long menuId, Long roleId) throws PKException;
    List<RoleMenu> findAllByRole(Role role) throws PKException;
    void deleteAllByRole(Role role) throws PKException;
}
