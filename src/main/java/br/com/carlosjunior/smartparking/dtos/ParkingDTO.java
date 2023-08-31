package br.com.carlosjunior.smartparking.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingDTO {

    private Long idParking;
    private String name;
    private List<ParkingItemDTO> parkingSpaces = new ArrayList<>();


}
