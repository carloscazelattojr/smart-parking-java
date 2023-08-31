package br.com.carlosjunior.smartparking.dtos;

import br.com.carlosjunior.smartparking.entities.ParkingSchedule;
import br.com.carlosjunior.smartparking.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingScheduleDTO {

    private Long idParkingSchedule;
    private ParkingItemDTO parkingItem;
    private VehicleDTO vehicle;
    private ParkingValuesDTO parkingValues;
    private LocalDate entryDate;
    private LocalTime entryTime;
    private LocalDate exitDate;
    private LocalTime exitTime;
    private StatusEnum status;
    private Long durationMinute;
    private Double totalCost;

    public ParkingScheduleDTO(ParkingSchedule entity) {
        this.idParkingSchedule = entity.getIdParkingSchedule();
        this.parkingItem = new ParkingItemDTO(entity.getParkingItem());
        this.vehicle = new VehicleDTO(entity.getVehicle());
        this.parkingValues = new ParkingValuesDTO(entity.getParkingValues());
        this.entryDate = entity.getEntryDate();
        this.entryTime = entity.getEntryTime();
        this.exitDate = entity.getExitDate();
        this.exitTime = entity.getExitTime();
        this.status = entity.getStatus();
        this.durationMinute = entity.getDurationMinute();
        this.totalCost = entity.getTotalCost();
    }
}
