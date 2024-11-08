package com.conurets.parking_kiosk.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="pk_users")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity{
    @Column(name = "str_first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name = "str_last_name", nullable = false, length = 80)
    private String lastName;

    @Column(name = "str_email_address", nullable = false, length = 50)
    private String emailAddress;

    @Column(name = "str_alternate_email_address", nullable = true, length = 50)
    private String alternateEmailAddress;

    @Column(name = "str_mobile_phone", nullable = false, length = 20)
    private String mobilePhone;
}
