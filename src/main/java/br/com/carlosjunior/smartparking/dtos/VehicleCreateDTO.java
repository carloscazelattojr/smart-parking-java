package br.com.carlosjunior.smartparking.dtos;


import lombok.Data;

@Data
public class VehicleDTO {

    private Long idVehicle;
    private String model;
    private String licensePlate;
}
