package com.conurets.parking_kiosk.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "pk_property_type")
public class PropertyType extends BaseEntity{

    @Column(name = "type_name")
    private String name;
}
