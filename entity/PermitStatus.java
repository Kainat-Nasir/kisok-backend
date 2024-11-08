package com.conurets.parking_kiosk.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="pk_permit_status")
public class PermitStatus extends BaseEntity {
    @Column(name = "str_name")
    private String name;

    @Column(name = "Description")
    private String description;

}
