package br.com.carlosjunior.smartparking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingItem extends JpaRepository<ParkingItem, Long> {
}
