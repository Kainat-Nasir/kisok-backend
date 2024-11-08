package com.conurets.parking_kiosk.persistence.repository;

import com.conurets.parking_kiosk.persistence.entity.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyTypeRepository extends JpaRepository<PropertyType,Integer> {
}
