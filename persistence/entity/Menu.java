package com.conurets.parking_kiosk.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Data
@Entity
@Table(name = "pk_menus")
@EqualsAndHashCode(callSuper = false)
public class Menu extends BaseEntity {

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "id_parent_menu", referencedColumnName = "id")
    private Menu parentMenu;

    @JsonManagedReference
    @OneToMany(mappedBy = "parentMenu", cascade = CascadeType.ALL)
    private List<Menu> children = new ArrayList<>();

    @Column(name = "str_name", nullable = false, length = 100)
    private String menuName;

    @Column(name = "str_icon", length = 100)
    private String menuIcon;

    @Column(name = "str_css_class", length = 100)
    private String menuCssClass;

    @Column(name = "str_href", length = 500)
    private String menuHref;

    @Column(name = "int_sequence", nullable = false)
    private Integer menuSequence;


    @Override
    public String toString() {
        return "Menu{" +
                "menuName='" + menuName + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuCssClass='" + menuCssClass + '\'' +
                ", menuHref='" + menuHref + '\'' +
                ", menuSequence=" + menuSequence +
                ", parentMenu=" + parentMenu +
                '}';
    }
}