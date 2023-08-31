package br.com.carlosjunior.smartparking.dtos;

import br.com.carlosjunior.smartparking.entities.ParkingSpace;
import br.com.carlosjunior.smartparking.enums.VehicleTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpaceDTO {

    private Long idParkingSpace;

    private String number;

    private Boolean isPcd;

    private VehicleTypeEnum vehicleType;

    public ParkingSpaceDTO(ParkingSpace entity) {
        this.idParkingSpace = entity.getIdParkingSpace();
        this.number = entity.getNumber();
        this.isPcd = entity.getIsPcd();
        this.vehicleType = entity.getVehicleType();
    }

    public ParkingSpace toEntity() {
        ParkingSpace entity = new ParkingSpace();
        entity.setIdParkingSpace(this.idParkingSpace);
        entity.setNumber(this.number);
        entity.setIsPcd(this.isPcd);
        entity.setVehicleType(this.vehicleType);
        return entity;
    }
}
