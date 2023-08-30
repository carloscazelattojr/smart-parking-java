package br.com.carlosjunior.smartparking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_parking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParking;

    private String name;

    @OneToMany(mappedBy = "parking")
    private List<ParkingItem> parkingSpaces = new ArrayList<>();


}
