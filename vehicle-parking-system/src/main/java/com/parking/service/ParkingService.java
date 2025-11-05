package com.parking.service;

import com.parking.model.ParkingSlot;
import com.parking.model.ParkingTransaction;
import com.parking.repository.ParkingSlotRepository;
import com.parking.repository.ParkingTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParkingService {
    @Autowired
    private ParkingSlotRepository slotRepo;

    @Autowired
    private ParkingTransactionRepository txnRepo;

    public ParkingTransaction parkVehicle(String vehicleNumber) {
        ParkingSlot slot = slotRepo.findFirstByStatus("AVAILABLE")
                .orElseThrow(() -> new RuntimeException("No slots Available"));
        slot.setStatus("OCCUPIED");
        slot.setVehicleNumber(vehicleNumber);
        slotRepo.save(slot);

        ParkingTransaction txn = new ParkingTransaction();
        txn.setVehicleNumber(vehicleNumber);
        txn.setEntryTime(LocalDateTime.now());
        txn.setSlot(slot);

        return txnRepo.save(txn);
    }

    public ParkingTransaction exitVehicle(String vehicleNumber) {
        ParkingTransaction txn = txnRepo.findByVehicleNumberAndExitTimeIsNull(vehicleNumber)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        txn.setExitTime(LocalDateTime.now());
        txn.setAmount(Duration.between(txn.getEntryTime(), txn.getExitTime()).toMinutes() * 2.0);

        ParkingSlot slot = txn.getSlot();
        slot.setStatus("AVAILABLE");
        slot.setVehicleNumber(null);
        slotRepo.save(slot);

        return txnRepo.save(txn);
    }

    public List<ParkingSlot> getAllSlots() {
        return slotRepo.findAll();
    }
}
