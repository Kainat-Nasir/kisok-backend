package com.conurets.parking_kiosk.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Data
@Entity
@Table(name = "pk_user_roles")
@EqualsAndHashCode(callSuper = false)
public class UserRole extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
}
