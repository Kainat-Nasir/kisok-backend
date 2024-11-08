package com.conurets.parking_kiosk.service.Impl;

import com.conurets.parking_kiosk.base.dto.request.RoleMenuRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.MenuPrivilegeResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.PKConstants;
import com.conurets.parking_kiosk.base.util.PKUtil;
import com.conurets.parking_kiosk.mapper.RoleMenuMapper;
import com.conurets.parking_kiosk.persistence.entity.Menu;
import com.conurets.parking_kiosk.persistence.entity.Role;
import com.conurets.parking_kiosk.persistence.entity.RoleMenu;
import com.conurets.parking_kiosk.persistence.repository.MenuRepository;
import com.conurets.parking_kiosk.persistence.repository.RoleMenuRepository;
import com.conurets.parking_kiosk.persistence.repository.RoleRepository;
import com.conurets.parking_kiosk.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Zohaib Ahmed
 * @version 1.0
 */

@Service
public class RoleMenuServiceImpl extends BaseServiceImpl implements RoleMenuService {

    RoleMenuRepository roleMenuRepository;
    RoleMenuMapper roleMenuMapper;
    RoleRepository roleRepository;
    MenuRepository menuRepository;

    @Autowired
    public RoleMenuServiceImpl(RoleMenuRepository roleMenuRepository,
                               RoleMenuMapper roleMenuMapper,
                               RoleRepository roleRepository,
                               MenuRepository menuRepository) {
        this.roleMenuRepository = roleMenuRepository;
        this.roleMenuMapper = roleMenuMapper;
        this.roleRepository = roleRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public List<MenuPrivilegeResponseDTO> FindRoleWithMenus() throws PKException {
        List<MenuPrivilegeResponseDTO> responseDTOS = new ArrayList<>();
        List<RoleMenu> roleMenus = roleMenuRepository.findAll();

        if (PKUtil.isCollectionNotBlank(roleMenus)) {
            responseDTOS = roleMenuMapper.FindRoleWithMenus(roleMenus);
        }

        return responseDTOS;
    }

    private void insertParentMenus(Menu menu, Role role, List<RoleMenu> roleMenus, RoleMenuRequestDTO roleMenuRequestDTO) throws PKException {
        // Check if the menu has a parent
        if(menu.getParentMenu() != null) {
            Menu parentMenu = menu.getParentMenu();

            // Check if the parent menu is already in the role_menu table
            Optional<RoleMenu> parentRoleMenu = roleMenuRepository.findByMenuIdAndRoleId(parentMenu.getId(), role.getId());

            if(!parentRoleMenu.isPresent()) {
                // If the parent menu is not present, insert its parents first (recursive call)
                insertParentMenus(parentMenu, role, roleMenus, roleMenuRequestDTO);

                // Add the parent menu itself to the list
                if (roleMenus.stream().noneMatch(roleMenu -> roleMenu.getMenu().getId().equals(parentMenu.getId()))) {
                    roleMenus.add(roleMenuMapper.addRoleMenu(roleMenuRequestDTO, parentMenu, role));
                }

            }
        }
    }

    @Override
    @Transactional
    public void AddMenusWithRoles(RoleMenuRequestDTO roleMenuRequestDTO) throws PKException {
        Role role = roleRepository.findById(roleMenuRequestDTO.getRoleId()).get();

        // Check if role exists
        if(role == null){
            throw new PKException("Role not found with ID: "+roleMenuRequestDTO.getRoleId());
        }

        roleMenuRepository.deleteAllByRole(role);

        List<RoleMenu> roleMenus = new ArrayList<>();
        for(Long menuId: roleMenuRequestDTO.getMenuId()) {
            //If Filtered Ids does not match with the request payload
            Optional<Menu> menu = menuRepository.findById(menuId);

            //Check if menu exists
            if (menu.isEmpty()) {
                throw new PKException("Menu not found with ID: " + menuId);
            }
            if (menu.get().getParentMenu() == null ) { // If the inserted menu Id is a parent itself

                if(roleMenus.stream().noneMatch(roleMenu -> roleMenu.getMenu().getId().equals(menu.get().getId()))){
                    roleMenus.add(roleMenuMapper.addRoleMenu(roleMenuRequestDTO, menu.get(), role));
                }

            } else if (menu.get().getParentMenu() != null ) { // If the inserted menu Id is the child
                insertParentMenus(menu.get(), role, roleMenus, roleMenuRequestDTO);
                roleMenus.add(roleMenuMapper.addRoleMenu(roleMenuRequestDTO, menu.get(), role));
            }

        }
        // If this list is filled with new records only then save to database
        if(roleMenus.size() > 0){
            roleMenuRepository.saveAll(roleMenus);
        }
    }



}
