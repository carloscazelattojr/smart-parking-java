package br.com.carlosjunior.smartparking.dtos;

import br.com.carlosjunior.smartparking.entities.Parking;
import br.com.carlosjunior.smartparking.enums.StatusEnum;
import lombok.Data;

@Data
public class ParkingItemDTO {

    private Long idParkingItem;
    private Parking parking;
    private StatusEnum status;
    private ParkingSpaceDTO parkingSpace;

}
