package br.com.carlosjunior.smartparking.dtos;


import br.com.carlosjunior.smartparking.entities.Vehicle;
import br.com.carlosjunior.smartparking.enums.VehicleTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {

    private Long idVehicle;
    private String model;
    private String licensePlate;
    private VehicleTypeEnum vehicleType;

    public VehicleDTO(Vehicle entity) {
        this.idVehicle = entity.getIdVehicle();
        this.model = entity.getModel();
        this.licensePlate = entity.getLicensePlate();
        this.vehicleType = entity.getVehicleType();
    }

    public Vehicle toEntity() {
        Vehicle entity = new Vehicle();
        entity.setIdVehicle(this.idVehicle);
        entity.setModel(this.model);
        entity.setLicensePlate(this.licensePlate);
        entity.setVehicleType(this.vehicleType);
        return entity;
    }
}
