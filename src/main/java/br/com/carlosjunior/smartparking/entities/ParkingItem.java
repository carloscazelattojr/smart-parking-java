package br.com.carlosjunior.smartparking.entities;


import br.com.carlosjunior.smartparking.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_parking_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParkingItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_parking")
    private Parking parking;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @OneToOne
    @JoinColumn(name = "idParkingSpace", referencedColumnName = "idParkingSpace")
    private ParkingSpace parkingSpace;



}
