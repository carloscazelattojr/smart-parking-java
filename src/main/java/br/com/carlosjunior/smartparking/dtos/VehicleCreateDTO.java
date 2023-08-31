package br.com.carlosjunior.smartparking.dtos;


import br.com.carlosjunior.smartparking.enums.VehicleTypeEnum;
import br.com.carlosjunior.smartparking.exceptions.BadRequestException;
import br.com.carlosjunior.smartparking.utils.MessagesExceptions;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.util.Optional.ofNullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleCreateDTO {

    @NotEmpty(message = "Obrigatório informar o modelo do veículo")
    private String model;

    @NotEmpty(message = "Obrigatório informar a placa do veículo")
    private String licensePlate;

    @NotNull(message = "Tipo do veículo é obrigatório")
    private VehicleTypeEnum vehicleType;

    public VehicleCreateDTO(VehicleDTO dto) {
        this.model = ofNullable(dto.getModel()).orElseThrow(() -> new BadRequestException(String.format(MessagesExceptions.FIELD_MANDATORY, "Modelo do veículo")));
        this.licensePlate = ofNullable(dto.getLicensePlate()).orElseThrow(() -> new BadRequestException(String.format(MessagesExceptions.FIELD_MANDATORY, "Placa do veículo")));
        this.vehicleType =  ofNullable(dto.getVehicleType()).orElseThrow(() -> new BadRequestException(String.format(MessagesExceptions.FIELD_MANDATORY, "Tipo do veículo")));
    }
}
