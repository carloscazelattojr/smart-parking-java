package br.com.carlosjunior.smartparking.entities;

import br.com.carlosjunior.smartparking.enums.VehicleTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_parking_values")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingValues {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParkingValues;
    private Double valueMinute;
    @Enumerated(EnumType.STRING)
    private VehicleTypeEnum vehicleType;
    private Boolean isActive;
}
