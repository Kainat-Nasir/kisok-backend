package com.conurets.parking_kiosk.persistence.repository;

import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.Role;
import com.conurets.parking_kiosk.persistence.entity.User;
import com.conurets.parking_kiosk.persistence.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findAllByUserId(Long userId) throws PKException;
    Optional<UserRole> findByUserId(Long userId) throws PKException;
}
