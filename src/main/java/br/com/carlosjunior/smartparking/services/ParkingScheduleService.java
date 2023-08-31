package br.com.carlosjunior.smartparking.services;

import br.com.carlosjunior.smartparking.dtos.ParkingScheduleRegistryDTO;
import br.com.carlosjunior.smartparking.dtos.ParkingScheduleDTO;

public interface ParkingScheduleService {

    ParkingScheduleDTO entryParking(ParkingScheduleRegistryDTO dto);

    ParkingScheduleDTO exitParking(ParkingScheduleRegistryDTO dto);

}
