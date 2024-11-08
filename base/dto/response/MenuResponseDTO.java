package com.conurets.parking_kiosk.base.dto.response;

import com.conurets.parking_kiosk.persistence.entity.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class MenuResponseDTO implements Serializable {

    private Long id;
    private Menu parentMenu;
    private String menuName;
    private String menuIcon;
    private String menuCssClass;
    private String menuHref;
    private Integer menuSequence;
    private Integer status;
    private List<MenuResponseDTO> children = new ArrayList<>();
}
