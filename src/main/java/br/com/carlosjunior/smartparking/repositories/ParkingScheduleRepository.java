package br.com.carlosjunior.smartparking.repositories;

import br.com.carlosjunior.smartparking.entities.ParkingSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface ParkingScheduleRepository extends JpaRepository<ParkingSchedule, Long> {


    @Query("select p from ParkingSchedule p " +
            " where p.parkingItem.idParkingItem = :idParkingItem " +
            " and (:licensePlate is null or p.vehicle.licensePlate = :licensePlate ) " +
            " and p.entryDate= :entryDate " +
            " and :entryTime between p.entryTime and coalesce(p.exitTime, p.entryTime)  "
    )
    ParkingSchedule findParkingSchedule(Long idParkingItem,
                                        String licensePlate,
                                        LocalDate entryDate,
                                        LocalTime entryTime);

    @Query("select p from ParkingSchedule p " +
            " where p.parkingItem.idParkingItem = :idParkingItem " +
            " and (:licensePlate is null or p.vehicle.licensePlate = :licensePlate ) " +
            " and :exitDate >= p.entryDate " +
            " and :exitTime >= p.entryTime " +
            "and p.exitTime is null" )
    Optional<ParkingSchedule> findParkingScheduleExit(Long idParkingItem,
                                                      String licensePlate,
                                                      LocalDate exitDate,
                                                      LocalTime exitTime);

}
