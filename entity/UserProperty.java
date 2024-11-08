package com.conurets.parking_kiosk.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "pk_user_properties")
@Data
@EqualsAndHashCode
public class UserProperty extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

}
