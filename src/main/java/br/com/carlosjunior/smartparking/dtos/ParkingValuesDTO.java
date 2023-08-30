package br.com.carlosjunior.smartparking.dtos;

import br.com.carlosjunior.smartparking.enums.VehicleTypeEnum;
import lombok.Data;

@Data
public class ParkingValuesDTO {

    private Long idParkingValues;
    private Double valueMinute;
    private VehicleTypeEnum vehicleType;
    private Boolean isActive;
}
