package com.parking.controller;

import com.parking.service.ParkingService;
import com.parking.model.ParkingTransaction;
import com.parking.model.ParkingSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    private ParkingService service;

    @GetMapping("/entry")
    public String showEntryForm() {
        return "parking-entry";
    }

    @PostMapping("/entry")
    public String entry(@RequestParam String vehicleNumber, Model model) {
        ParkingTransaction txn = service.parkVehicle(vehicleNumber);
        model.addAttribute("txn", txn);
        return "parking-entry";
    }

    @GetMapping("/exit")
    public String showExitForm() {
        return "parking-exit";
    }

    @PostMapping("/exit")
    public String exit(@RequestParam String vehicleNumber, Model model) {
        ParkingTransaction txn = service.exitVehicle(vehicleNumber);
        model.addAttribute("txn", txn);
        return "parking-exit";
    }

    @GetMapping("/slots")
    public String slots(Model model) {
        List<ParkingSlot> slots = service.getAllSlots();
        model.addAttribute("slots", slots);
        return "parking-slots";
    }
}
