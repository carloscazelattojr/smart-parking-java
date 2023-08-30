package br.com.carlosjunior.smartparking.services;

import br.com.carlosjunior.smartparking.dtos.VehicleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VehicleService {

    Page<VehicleDTO> findAllPaged(Pageable pageable);
    VehicleDTO findById(Long id);

}
