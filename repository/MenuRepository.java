package com.conurets.parking_kiosk.persistence.repository;

import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Long> {
    List<Menu> findByParentMenu(Menu menu) throws PKException;
    Menu findAllById(Long Id) throws PKException;
}
