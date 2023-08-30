package br.com.carlosjunior.smartparking.services.impl;

import br.com.carlosjunior.smartparking.dtos.ParkingValuesDTO;
import br.com.carlosjunior.smartparking.services.ParkingValuesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ParkingValuesServiceImpl implements ParkingValuesService {
    @Override
    public ParkingValuesDTO findById(Long aLong) {
        return null;
    }

    @Override
    public Page<ParkingValuesDTO> findAllPaged(Pageable pageable) {
        return null;
    }
}
