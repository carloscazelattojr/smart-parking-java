package br.com.carlosjunior.smartparking.services;

import br.com.carlosjunior.smartparking.dtos.ParkingDTO;

public interface ParkingService {


    ParkingDTO findById(Long id);
}
