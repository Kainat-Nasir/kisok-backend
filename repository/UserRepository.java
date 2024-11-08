package com.conurets.parking_kiosk.persistence.repository;

import com.conurets.parking_kiosk.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAddress(String email);

    @Query(value = "Select * from pk_users where int_status=1 order by id", nativeQuery = true)
    List<User> findUsersByStatusEqualsOne();
}