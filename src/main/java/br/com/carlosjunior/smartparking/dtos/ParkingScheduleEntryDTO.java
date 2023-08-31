package br.com.carlosjunior.smartparking.dtos;

import br.com.carlosjunior.smartparking.enums.StatusEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParkingScheduleCreateDTO {

    private ParkingItemDTO parkingItem;
    private VehicleDTO vehicle;
    private LocalDateTime entryTime;
    private StatusEnum status;
}
