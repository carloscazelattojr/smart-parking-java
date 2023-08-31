package br.com.carlosjunior.smartparking.entities;

import br.com.carlosjunior.smartparking.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "America/Sao_Paulo")
    private LocalDate entryDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "America/Sao_Paulo")
    private LocalTime entryTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "America/Sao_Paulo")
    private LocalDate exitDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "America/Sao_Paulo")
    private LocalTime exitTime;

    private StatusEnum status;
    private Long durationMinute;
    private Double totalCost;

}
