package com.conurets.parking_kiosk.mapper;

import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.PKDateUtil;
import com.conurets.parking_kiosk.persistence.entity.BaseEntity;
import com.conurets.parking_kiosk.persistence.entity.RoleMenu;
import com.conurets.parking_kiosk.persistence.repository.*;
import com.conurets.parking_kiosk.security.util.PKSecurityUtil;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
@Getter
public abstract class BaseMapper {

    @PostConstruct
    public void init() {
    }

    /**
     * Set created by, created date, last update by and last update date fields
     *
     * @param object
     * @throws PKException
     */
    protected final void addAuditingInformation(BaseEntity object) throws PKException {
        if (object.getId() == null) {
            object.setCreatedDate(PKDateUtil.getCurrentTimestamp());
            object.setCreatedBy(PKSecurityUtil.getLoggedInUserId());
        } else {
            object.setLastUpdate(PKDateUtil.getCurrentTimestamp());
            object.setLastUpdateBy(PKSecurityUtil.getLoggedInUserId());
        }
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository roleRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    RoleMenuRepository roleMenuRepository;

    @Autowired
    UserPropertyRepository propertyRepository;

    @Autowired
    PropertyTypeRepository propertyTypeRepository;

    @Autowired
    UserPropertyChildRepository childRepository;

    @Autowired
    ChildFloorRepository floorRepository;
}
