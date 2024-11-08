package com.conurets.parking_kiosk.service.Impl;

import com.conurets.parking_kiosk.base.util.PKValidationUtil;
import com.conurets.parking_kiosk.mapper.UserMapper;
import com.conurets.parking_kiosk.service.BaseService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

/**
 * Commons Base Service Implementation
 *
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
@Getter
public abstract class BaseServiceImpl implements BaseService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PKValidationUtil pkValidationUtil;
}
