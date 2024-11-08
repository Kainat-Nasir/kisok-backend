package com.conurets.parking_kiosk.persistence.repository;

import com.conurets.parking_kiosk.persistence.entity.PaymentStatus;
import com.conurets.parking_kiosk.persistence.entity.PermitStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface PaymentStatusRepository extends JpaRepository<PaymentStatus, Long> {
    List<PermitStatus> findByStatusNot(int status);
}
