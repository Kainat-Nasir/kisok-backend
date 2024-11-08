package com.conurets.parking_kiosk.persistence.repository;

import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.ChildFloor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildFloorRepository extends JpaRepository<ChildFloor,Long> {

    @Query(value = "Select * from pk_child_floor where child_property=? order by id" , nativeQuery = true)
    List<ChildFloor> findAllByUserPropertyChild(Long Id) throws PKException;
}
