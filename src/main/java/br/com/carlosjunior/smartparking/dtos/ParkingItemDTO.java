package br.com.carlosjunior.smartparking.dtos;

import br.com.carlosjunior.smartparking.enums.StatusEnum;
import lombok.Data;

@Data
public class ParkingItemDTO {

    private Long idParkingItem;
    private Long idParking;
    private StatusEnum status;
    private ParkingSpaceDTO parkingSpace;

}
