package com.conurets.parking_kiosk.persistence.repository;

import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.UserProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPropertyRepository extends JpaRepository<UserProperty, Long>{

//    List<UserProperty> findByStatusIn(List<Integer> statuses);
    List<UserProperty> findByStatusNot(Integer status);
}
