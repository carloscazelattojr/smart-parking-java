package br.com.carlosjunior.smartparking.entities;

import br.com.carlosjunior.smartparking.enums.VehicleTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_vehicle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicle;

    private String model;

    private String licensePlate;

    @Enumerated(EnumType.STRING)
    private VehicleTypeEnum vehicleType;

}
