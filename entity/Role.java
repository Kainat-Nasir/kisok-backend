package com.conurets.parking_kiosk.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Data
@Entity
@Table(name = "pk_roles")
@EqualsAndHashCode(callSuper = false)
public class Role extends BaseEntity {
    @Column(name = "str_name", length = 50, nullable = false, unique = true)
    private String name;

    @Column(name = "str_description", length = 200)
    private String description;
}
