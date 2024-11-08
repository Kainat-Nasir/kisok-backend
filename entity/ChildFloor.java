package com.conurets.parking_kiosk.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "pk_child_floor")
@Entity
@Data
@EqualsAndHashCode
public class ChildFloor extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String floorType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "childProperty", nullable = false)
    private UserPropertyChild userPropertyChild;

    public enum PropertyTypeEnum {
        PERMIT,
        PAYMENT
    }
}
