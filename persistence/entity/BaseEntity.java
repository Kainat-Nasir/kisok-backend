package com.conurets.parking_kiosk.persistence.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Adeel Ali
 * @version 1.0
 */
@Setter
@Getter
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "int_status", length = 2)
    private Integer status;

    @Column(name = "dat_created_date", updatable = false)
    private Timestamp createdDate;

    @Column(name = "int_created_by", updatable = false)
    private Long createdBy;

    @Column(name = "dat_modified_date", insertable = false)
    private Timestamp lastUpdate;

    @Column(name = "int_modified_by", insertable = false)
    private Long lastUpdateBy;
}