package br.com.carlosjunior.smartparking.repositories;

import br.com.carlosjunior.smartparking.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
