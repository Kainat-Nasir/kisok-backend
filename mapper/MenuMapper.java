package com.conurets.parking_kiosk.mapper;

import com.conurets.parking_kiosk.base.dto.request.MenuRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.MenuResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.Menu;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Zohaib Ahmed
 * @version 1.0
 */

@Component
public class MenuMapper extends BaseMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public MenuMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<MenuResponseDTO> getAllMenus(List<Menu> menuList) throws PKException {
        List<MenuResponseDTO> menuResponseDTOS = new ArrayList<>();
        menuResponseDTOS = modelMapper.map(menuList, menuResponseDTOS.getClass());
        return menuResponseDTOS;
    }

    public Menu addMenu(MenuRequestDTO menuRequestDTO) throws PKException {
        Menu menu = this.modelMapper.map(menuRequestDTO, Menu.class);
        addAuditingInformation(menu);

        return menu;
    }

    public Menu updateMenu(MenuRequestDTO menuRequestDTO) throws PKException {
        Menu menu = getMenuRepository().findById(menuRequestDTO.getId()).get(); // This statement only fetches current record without its parent
        if (menu != null) {
            addAuditingInformation(menu);
            this.modelMapper.map(menuRequestDTO, menu);
        }
        if (menuRequestDTO.getParentMenu() != null) {
            //Setting the parent of fetched record
            Menu parentMenu = getMenuRepository().findById(menuRequestDTO.getParentMenu())
                    .orElseThrow(() -> new PKException("Parent Menu not found"));
            menu.setParentMenu(parentMenu);
        } else {
            menu.setParentMenu(null); // if there's no parent menu
        }
        return menu;
    }

    public Menu deleteMenu(Long id) throws PKException {
        Menu menuDelete = getMenuRepository().findAllById(id);
        if (menuDelete != null) {
            addAuditingInformation(menuDelete);
        }
        return menuDelete;
    }


    public MenuResponseDTO getMenuResponse(Menu menu) throws PKException {
        return this.modelMapper.map(menu, MenuResponseDTO.class);
    }
}
