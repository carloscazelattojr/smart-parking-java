package br.com.carlosjunior.smartparking.dtos;

import br.com.carlosjunior.smartparking.entities.ParkingValues;
import br.com.carlosjunior.smartparking.enums.VehicleTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingValuesDTO {

    private Long idParkingValues;
    private Double valueMinute;
    private VehicleTypeEnum vehicleType;
    private Boolean isActive;

    public ParkingValuesDTO(ParkingValues entity) {
        this.idParkingValues = entity.getIdParkingValues();
        this.valueMinute = entity.getValueMinute();
        this.vehicleType = entity.getVehicleType();
        this.isActive = entity.getIsActive();
    }

    public ParkingValues toEntity() {
        ParkingValues entity = new ParkingValues();
        entity.setIdParkingValues(this.idParkingValues);
        entity.setValueMinute(this.valueMinute);
        entity.setVehicleType(this.vehicleType);
        entity.setIsActive(this.isActive);
        return entity;
    }
}
