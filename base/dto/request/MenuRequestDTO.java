package com.conurets.parking_kiosk.base.dto.request;

import com.conurets.parking_kiosk.persistence.entity.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Syed Irtaza
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class MenuRequestDTO extends BaseRequestDTO {

    private Long id;
    private Long parentMenu;
    private String menuName;
    private String menuIcon;
    private String menuCssClass;
    private String menuHref;
    private Integer menuSequence;
    private Integer status;
}
