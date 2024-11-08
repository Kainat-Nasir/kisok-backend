package com.conurets.parking_kiosk.service.Impl;

import com.conurets.parking_kiosk.base.dto.request.MenuRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.MenuResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.PKConstants;
import com.conurets.parking_kiosk.base.util.PKUtil;
import com.conurets.parking_kiosk.mapper.MenuMapper;
import com.conurets.parking_kiosk.persistence.entity.Menu;
import com.conurets.parking_kiosk.persistence.repository.MenuRepository;
import com.conurets.parking_kiosk.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zohaib Ahmed
 * @version 1.0
 */

@Service
public class MenuServiceImpl extends BaseServiceImpl implements MenuService {

    MenuRepository menuRepository;
    MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository,MenuMapper menuMapper) {
        this.menuRepository = menuRepository;
        this.menuMapper = menuMapper;
    }

    @Override
    public MenuResponseDTO addMenu(MenuRequestDTO menuRequestDTO) throws PKException {
        Menu menu = menuMapper.addMenu(menuRequestDTO);
        if(menuRequestDTO.getParentMenu() !=null){
            menu.setParentMenu(menuRepository.findById(menuRequestDTO.getParentMenu()).get());
        }
        menuRepository.save(menu);

        return menuMapper.getMenuResponse(menu);
    }

    @Override
    public MenuResponseDTO updateMenu(MenuRequestDTO model) throws PKException {
        Menu menu = menuMapper.updateMenu(model);

        if (menu.getParentMenu() == null && model.getStatus() != null) {
            updateChildrenStatus(menu, model.getStatus());
        }else {
            menu.setStatus(model.getStatus());
            menuRepository.save(menu);
        }

        return menuMapper.getMenuResponse(menu);
    }

    private void updateChildrenStatus(Menu parentMenu, Integer status) throws PKException {
        List<Menu> children = menuRepository.findByParentMenu(parentMenu);
        if (children != null) {
            for (Menu child : children) {
                child.setStatus(status);
                menuRepository.save(child);
                updateChildrenStatus(child, status);
            }
        }
    }

    @Override
    public List<MenuResponseDTO> getAllMenu() throws PKException {
        List<MenuResponseDTO> menuResponseDTOS = new ArrayList<>();
        List<Menu> menuList;
        menuList = menuRepository.findAll();

        if (PKUtil.isCollectionNotBlank(menuList)) {
            menuResponseDTOS = menuMapper.getAllMenus(menuList);
        }

        return menuResponseDTOS;
    }

    @Override
    public void deleteMenu(Long userId) throws PKException {
        Menu menu = menuMapper.deleteMenu(userId);

        if (menu.getParentMenu() == null && menu.getStatus() != null) {
            updateChildrenStatus(menu, PKConstants.Common.STATUS_CODE_DELETE); // For deleting all children
            menu.setStatus(PKConstants.Common.STATUS_CODE_DELETE); // For deleting parent
            menuRepository.save(menu);
        }else {
            menu.setStatus(PKConstants.Common.STATUS_CODE_DELETE);
            menuRepository.save(menu);
        }

//        return menuMapper.getMenuResponse(menu);
    }
}
