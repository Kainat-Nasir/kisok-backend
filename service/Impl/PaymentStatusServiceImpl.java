package com.conurets.parking_kiosk.service.Impl;

import com.conurets.parking_kiosk.base.dto.response.PaymentStatusResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.mapper.PaymentStatusMapper;
import com.conurets.parking_kiosk.persistence.entity.PaymentStatus;
import com.conurets.parking_kiosk.persistence.repository.PaymentStatusRepository;
import com.conurets.parking_kiosk.service.PaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Kainat Nasir
 * @version 1.0 B
 */
@Service
public class PaymentStatusServiceImpl  extends BaseServiceImpl implements PaymentStatusService {
    @Autowired
    private PaymentStatusRepository paymentStatusRepository;

    @Autowired
    private PaymentStatusMapper paymentStatusMapper;

    public List<PaymentStatusResponseDTO> findAllPaymentStatus() {
        List<PaymentStatus> paymentStatus = paymentStatusRepository.findAll();
        return paymentStatus.stream().map(paymentStatusMapper::find).collect(Collectors.toList());
    }
    public PaymentStatusResponseDTO findById(Long Id) throws PKException {
        Optional<PaymentStatus> paymentStatus = paymentStatusRepository.findById(Id);
        if(paymentStatus.isEmpty()){
            throw new PKException("payment Status Status not found");
        }
        return paymentStatusMapper.findById(paymentStatus.get());
    }
}
