package br.com.carlosjunior.smartparking.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ParkingDTO {

    private Long idParking;
    private String name;
    private List<ParkingItemDTO> parkingSpaces = new ArrayList<>();


}
