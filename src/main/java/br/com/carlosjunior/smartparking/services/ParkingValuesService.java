package br.com.carlosjunior.smartparking.services;

import br.com.carlosjunior.smartparking.dtos.ParkingValuesDTO;
import br.com.carlosjunior.smartparking.enums.VehicleTypeEnum;
import br.com.carlosjunior.smartparking.utils.BaseService;

public interface ParkingValuesService extends BaseService<Long, ParkingValuesDTO> {
    ParkingValuesDTO findParkingValuesByVehicleType(VehicleTypeEnum vehicleType);

}
