package br.com.carlosjunior.smartparking.services;

import br.com.carlosjunior.smartparking.dtos.VehicleCreateDTO;
import br.com.carlosjunior.smartparking.dtos.VehicleDTO;
import br.com.carlosjunior.smartparking.utils.BaseService;

public interface VehicleService extends BaseService<Long, VehicleDTO> {

    VehicleDTO findByLicensePlate(String licensePlate);

    VehicleDTO create(VehicleCreateDTO newVehicle);
}
