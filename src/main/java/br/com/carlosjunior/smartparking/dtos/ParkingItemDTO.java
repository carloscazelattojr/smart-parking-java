package br.com.carlosjunior.smartparking.dtos;

import br.com.carlosjunior.smartparking.entities.ParkingItem;
import br.com.carlosjunior.smartparking.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingItemDTO {

    private Long idParkingItem;
    private Long idParking;
    private StatusEnum status;
    private ParkingSpaceDTO parkingSpace;


    public ParkingItemDTO(ParkingItem entity) {
        this.idParkingItem = entity.getIdParkingItem();
        this.idParking = entity.getIdParking();
        this.status = entity.getStatus();
        this.parkingSpace = new ParkingSpaceDTO(entity.getParkingSpace());
    }

    public ParkingItem toEntity(){
        ParkingItem entity = new ParkingItem();
        entity.setIdParkingItem(this.idParkingItem);
        entity.setIdParking(this.idParking);
        entity.setStatus(this.status);
        entity.setParkingSpace(this.parkingSpace.toEntity());
        return entity;
    }


}
