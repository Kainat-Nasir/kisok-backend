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
@Table(name = "pk_preferences")
@EqualsAndHashCode(callSuper = false)
public class Preference extends BaseEntity {
    @Column(name = "str_name", nullable = false, length = 50)
    private String name;

    @Column(name = "str_value", nullable = false, length = 200)
    private String value;

    @Column(name = "str_description", nullable = false, length = 200)
    private String description;
}
