package com.conurets.parking_kiosk.service.Impl;

import com.conurets.parking_kiosk.base.dto.response.CameraResponseDTO;
import com.conurets.parking_kiosk.base.dto.response.PermitStatusResponseDTO;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.mapper.CameraMapper;
import com.conurets.parking_kiosk.mapper.PermitStatusMapper;
import com.conurets.parking_kiosk.persistence.entity.Camera;
import com.conurets.parking_kiosk.persistence.entity.PermitStatus;
import com.conurets.parking_kiosk.persistence.repository.CameraRepository;
import com.conurets.parking_kiosk.persistence.repository.PermitStatusRepository;
import com.conurets.parking_kiosk.service.PermitStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Kainat Nasir
 * @version 1.0
 */
@Service
public class PermitStatusServiceImpl extends BaseServiceImpl implements PermitStatusService {
    @Autowired
    private PermitStatusRepository permitStatusRepository;

    @Autowired
    private PermitStatusMapper permitStatusMapper;

    public List<PermitStatusResponseDTO> findAllPermitStatus() {
        List<PermitStatus> permitStatus = permitStatusRepository.findAll();
        return permitStatus.stream().map(permitStatusMapper::find).collect(Collectors.toList());
    }
    public PermitStatusResponseDTO findById(Long Id) throws PKException {
        Optional<PermitStatus> permitStatus = permitStatusRepository.findById(Id);
        if(permitStatus.isEmpty()){
            throw new PKException("permit Status not found");
        }
        return permitStatusMapper.findById(permitStatus.get());
    }
}
