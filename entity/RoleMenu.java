package com.conurets.parking_kiosk.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zohaib Ahmed
 * @version 1.0
 */

@Data
@Entity
@Table(name = "pk_role_menu")
@EqualsAndHashCode(callSuper = false)
public class RoleMenu extends BaseEntity{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_menu", nullable = true)
    private Menu menu;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role", nullable = true)
    private Role role;
}
