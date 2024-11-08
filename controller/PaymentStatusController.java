package com.conurets.parking_kiosk.controller;

import com.conurets.parking_kiosk.base.dto.response.BaseResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.PaymentStatusResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.PermitStatusResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.service.PaymentStatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Kainat Nasir
 * @version 1.0
 */
@RestController
@RequestMapping("/api/payment-status")
public class PaymentStatusController  extends BaseController{
    @Autowired
    private PaymentStatusService paymentStatusService;
    @GetMapping("/findAll")
    public BaseResponseDTO findAllPermitStatus() throws PKException {
        List<PaymentStatusResponseDTO> paymentStatus = paymentStatusService.findAllPaymentStatus();
        return response(paymentStatus);
    }

    @GetMapping(value = "findById/{Id}")
    public BaseResponseDTO findById(@PathVariable Long Id) throws PKException {
        PaymentStatusResponseDTO paymentStatus= paymentStatusService.findById(Id);
        return response(paymentStatus);
    }
}
