package com.conurets.parking_kiosk.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="pk_vehicle")
public class Vehicle extends BaseEntity {
    @Column(name = "str_name")
    private String name;

    @Column(name = "str_license-Plate")
    private int licensePlate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

}
