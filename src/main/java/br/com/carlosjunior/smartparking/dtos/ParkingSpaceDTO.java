package br.com.carlosjunior.smartparking.dtos;

import br.com.carlosjunior.smartparking.enums.VehicleTypeEnum;
import lombok.Data;

@Data
public class ParkingSpaceDTO {

    private Long idParkingSpace;

    private String number;

    private Boolean isPcd;

    private VehicleTypeEnum vehicleType;
}
