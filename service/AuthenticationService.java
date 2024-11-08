package com.conurets.parking_kiosk.service;

import com.conurets.parking_kiosk.base.dto.request.AuthenticationRequestDTO;
import com.conurets.parking_kiosk.base.dto.response.AuthenticationResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public interface AuthenticationService {
    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO model) throws PKException;

    void logout() throws PKException;
}
