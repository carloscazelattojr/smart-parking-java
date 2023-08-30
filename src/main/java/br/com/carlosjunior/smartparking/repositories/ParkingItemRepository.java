package br.com.carlosjunior.smartparking.repositories;

import br.com.carlosjunior.smartparking.entities.ParkingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingItemRepository extends JpaRepository<ParkingItem, Long> {
}
