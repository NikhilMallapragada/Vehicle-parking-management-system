package com.parking.controller;

import com.parking.model.Vehicle;
import com.parking.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService service;

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicle-form";
    }

    @PostMapping("/save")
    public String saveVehicle(@ModelAttribute Vehicle vehicle, Model model) {
        service.addVehicle(vehicle);
        model.addAttribute("vehicles", service.getAllVehicles());
        return "vehicle-list";
    }

    @GetMapping("/list")
    public String listVehicles(Model model) {
        model.addAttribute("vehicles", service.getAllVehicles());
        return "vehicle-list";
    }
}
