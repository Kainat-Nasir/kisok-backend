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
@Table(name = "pk_user_logins")
@EqualsAndHashCode(callSuper = false)
public class UserLogin extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "str_credential", nullable = false, length = 100)
    private String credential;
}
