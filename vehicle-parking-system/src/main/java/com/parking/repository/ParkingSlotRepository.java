package com.parking.repository;

import com.parking.model.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {
    Optional<ParkingSlot> findFirstByStatus(String status);
}
