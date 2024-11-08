package com.conurets.parking_kiosk.persistence.repository;

import com.conurets.parking_kiosk.persistence.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {
    Optional<Preference> findByName(String key);
}
