package br.com.carlosjunior.smartparking.repositories;

import br.com.carlosjunior.smartparking.entities.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {
}
