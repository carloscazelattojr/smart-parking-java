package br.com.carlosjunior.smartparking.entities;

import br.com.carlosjunior.smartparking.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_parking_schedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParkingSchedule;

    @OneToOne
    @JoinColumn(name = "idParkingItem", referencedColumnName = "idParkingItem")
    private ParkingItem parkingItem;

    @OneToOne
    @JoinColumn(name = "idVehicle", referencedColumnName = "idVehicle")
    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name = "idParkingValues", referencedColumnName = "idParkingValues")
    private ParkingValues parkingValues;

    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    private StatusEnum status;
    private Double durationMinute;
    private Double totalCost;

}
