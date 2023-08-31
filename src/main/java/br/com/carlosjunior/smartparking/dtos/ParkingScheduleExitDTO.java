package br.com.carlosjunior.smartparking.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParkingScheduleEntryDTO {

    @NotNull(message = "Obrigatório informar a vaga ")
    private ParkingItemDTO parkingItem;
    @NotNull(message = "Obrigatório informar o veículo ")
    private VehicleDTO vehicle;
    @NotNull(message = "Obrigatório informar data hora entrada ")
    private LocalDateTime entryTime;
}
