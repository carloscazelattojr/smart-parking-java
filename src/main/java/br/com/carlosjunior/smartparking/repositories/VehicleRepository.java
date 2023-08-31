package br.com.carlosjunior.smartparking.repositories;

import br.com.carlosjunior.smartparking.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findByLicensePlate(String licensePlate);

}
