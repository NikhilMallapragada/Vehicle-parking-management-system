package com.parking.service;

import com.parking.model.Vehicle;
import com.parking.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository repo;

    public Vehicle addVehicle(Vehicle vehicle) {
        return repo.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return repo.findAll();
    }
}
