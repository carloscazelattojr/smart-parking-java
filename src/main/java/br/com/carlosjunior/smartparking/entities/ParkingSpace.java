package br.com.carlosjunior.smartparking.entities;

import br.com.carlosjunior.smartparking.enums.VehicleTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_parking_space")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParkingSpace;

    private String number;

    private Boolean isPcd;

    @Enumerated(EnumType.STRING)
    private VehicleTypeEnum vehicleType;

}
