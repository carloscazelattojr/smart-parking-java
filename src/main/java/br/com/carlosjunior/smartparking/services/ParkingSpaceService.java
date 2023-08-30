package br.com.carlosjunior.smartparking.services;

import br.com.carlosjunior.smartparking.dtos.ParkingSpaceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ParkingSpaceService {

    Page<ParkingSpaceDTO> findAllPaged(Pageable pageable);

    ParkingSpaceDTO findById(Long id);
}
