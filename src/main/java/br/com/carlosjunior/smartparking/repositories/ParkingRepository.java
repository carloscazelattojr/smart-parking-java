package br.com.carlosjunior.smartparking.repositories;

import br.com.carlosjunior.smartparking.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
