package br.com.carlosjunior.smartparking.services.impl;

import br.com.carlosjunior.smartparking.dtos.ParkingScheduleDTO;
import br.com.carlosjunior.smartparking.services.ParkingScheduleService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ParkingScheduleServiceImpl implements ParkingScheduleService {

    @Override
    public ParkingScheduleDTO create(ParkingScheduleDTO dto) {
        return null;
    }
}
