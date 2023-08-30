package br.com.carlosjunior.smartparking.repositories;

import br.com.carlosjunior.smartparking.entities.ParkingValues;
import br.com.carlosjunior.smartparking.enums.VehicleTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingValuesRepository extends JpaRepository<ParkingValues, Long> {

    ParkingValues findByVehicleTypeAndIsActiveTrue(VehicleTypeEnum vehicleType);

}
