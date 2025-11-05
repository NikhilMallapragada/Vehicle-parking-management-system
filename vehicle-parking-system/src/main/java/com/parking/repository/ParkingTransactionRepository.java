package com.parking.repository;

import com.parking.model.ParkingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ParkingTransactionRepository extends JpaRepository<ParkingTransaction, Long> {
    Optional<ParkingTransaction> findByVehicleNumberAndExitTimeIsNull(String vehicleNumber);
}
