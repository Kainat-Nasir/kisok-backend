package com.conurets.parking_kiosk.persistence.repository;

import com.conurets.parking_kiosk.persistence.entity.PermitStatus;
import com.conurets.parking_kiosk.persistence.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermitStatusRepository extends JpaRepository<PermitStatus, Long> {
    List<PermitStatus> findByStatusNot(int status);
}
