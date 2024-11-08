package com.conurets.parking_kiosk.service;

import com.conurets.parking_kiosk.base.dto.response.PaymentStatusResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.PermitStatusResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;

import java.util.List;

public interface PaymentStatusService {
    List<PaymentStatusResponseDTO> findAllPaymentStatus();
    PaymentStatusResponseDTO findById(Long Id) throws PKException;
}
