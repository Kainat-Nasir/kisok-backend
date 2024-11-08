package com.conurets.parking_kiosk.mapper;

import com.conurets.parking_kiosk.base.dto.response.PaymentStatusResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.PaymentStatus;
import com.conurets.parking_kiosk.persistence.repository.PaymentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Kainat Nasir
 * @version 1.0
 */

@Component
public class PaymentStatusMapper extends BaseMapper {
    @Autowired
    private PaymentStatusRepository PaymentStatusRepository;

    public PaymentStatusResponseDTO find(PaymentStatus paymentStatus) throws PKException {
        PaymentStatusResponseDTO response = new PaymentStatusResponseDTO();
        response.setId(paymentStatus.getId());
        response.setName(paymentStatus.getName());
        response.setDescription(paymentStatus.getDescription());
        response.setStatus(paymentStatus.getStatus());
        return response;
    }
    public PaymentStatusResponseDTO findById(PaymentStatus paymentStatus){
        PaymentStatusResponseDTO responseDTO = new PaymentStatusResponseDTO();
        responseDTO.setId(paymentStatus.getId());
        responseDTO.setName(paymentStatus.getName());
        responseDTO.setDescription(paymentStatus.getDescription());
        responseDTO.setStatus(paymentStatus.getStatus());
        return responseDTO;
    }
}
