package com.logisticApp.controllers;


import com.logisticApp.entities.Vehicle;
import com.logisticApp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/vehicles")
public class VehicleController {
    private VehicleService vehicleService;

    @GetMapping("")
    public String vehiclePage(Model model) {
        List<Vehicle> vehicleList = vehicleService.getAllActiveVehicle();
        model.addAttribute("vehicles", vehicleList);
        return "vehicle-page";
    }

    @GetMapping("/remove/{id}")
    public String removeEmployeeById(@PathVariable(name = "id") Long id, Model model) {
        vehicleService.removeVehicle(id);
        return "redirect:/vehicles";
    }

    @Autowired
    public void setVehicleService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
}
