package com.conurets.parking_kiosk.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "pk_user_property_child")
public class UserPropertyChild extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "capacity")
    private Double capacity;

    @Column(name = "location",columnDefinition = "geometry(Point,4326)")
    private org.locationtech.jts.geom.Point location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_property", nullable = false)
    private UserProperty userProperty;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_propertyType", nullable = false)
    private PropertyType propertyType;
}
