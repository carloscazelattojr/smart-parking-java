package br.com.carlosjunior.smartparking.repositories;

import br.com.carlosjunior.smartparking.entities.ParkingSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingScheduleRepository extends JpaRepository<ParkingSchedule, Long> {
}
