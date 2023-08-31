package br.com.carlosjunior.smartparking.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ParkingScheduleRegistryDTO {

    @NotNull(message = "Obrigatório informar a vaga ")
    private Long idParkingItem;

    @NotNull(message = "Obrigatório informar o veículo ")
    private VehicleDTO vehicle;



}
