package com.conurets.parking_kiosk.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
/**
 * @author Kainat Nasir
 * @version 1.0
 */
@Entity
@Data
@Table(name="pk_camera")
public class Camera extends BaseEntity {
    @Column(name = "Name")
    private String name;

    @Column(name = "IP")
    private int ip;

    @Column(name = "Description")
    private String description;

    @Column(name = "Type" )
    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_propertyChild")
    private UserPropertyChild userPropertyChild;


}
