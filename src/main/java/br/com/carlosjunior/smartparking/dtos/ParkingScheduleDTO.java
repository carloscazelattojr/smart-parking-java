package br.com.carlosjunior.smartparking.dtos;

import br.com.carlosjunior.smartparking.entities.ParkingValues;
import br.com.carlosjunior.smartparking.enums.StatusEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParkingScheduleDTO {

    private Long idParkingSchedule;
    private ParkingItemDTO parkingItem;
    private VehicleDTO vehicle;
    private ParkingValuesDTO parkingValues;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private StatusEnum status;
    private Double durationMinute;
    private Double totalCost;
}
