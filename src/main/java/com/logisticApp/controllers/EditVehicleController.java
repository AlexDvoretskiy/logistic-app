package com.logisticApp.controllers;


import com.logisticApp.dto.VehicleDto;
import com.logisticApp.entities.VehicleType;
import com.logisticApp.services.VehicleService;
import com.logisticApp.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/editVehicle")
public class EditVehicleController {
    private VehicleService vehicleService;
    private VehicleTypeService vehicleTypeService;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("")
    public String addVehiclePage(Model model) {
        List<VehicleType> vehicleTypeList = vehicleTypeService.getAllVehicleTypes();

        model.addAttribute("vehicleTypes", vehicleTypeList);
        model.addAttribute("vehicleDto", new VehicleDto());

        return "add-vehicle-page";
    }

    @PostMapping("/add")
    public String addVehicle(@Valid @ModelAttribute("vehicleDto") VehicleDto vehicleDto, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            List<VehicleType> vehicleTypeList = vehicleTypeService.getAllVehicleTypes();
            model.addAttribute("vehicleTypes", vehicleTypeList);
            return "add-vehicle-page";
        }
        vehicleService.saveVehicle(vehicleDto);
        return "redirect:/vehicles";
    }

    @GetMapping("/change/{id}")
    public String editVehiclePage(@PathVariable(name = "id") Long id, Model model) {
        List<VehicleType> vehicleTypeList = vehicleTypeService.getAllVehicleTypes();
        VehicleDto vehicleDto = vehicleService.getVehicleDtoByVehicleId(id);

        model.addAttribute("vehicleTypes", vehicleTypeList);
        model.addAttribute("vehicleDto", vehicleDto);

        return "edit-vehicle-page";
    }

    @PostMapping("/change/{id}")
    public String changeVehicleById(@ModelAttribute("employeeDto") VehicleDto vehicleDto, @PathVariable(name = "id") Long id, Model model) {
        vehicleService.updateVehicle(vehicleDto, id);
        return "redirect:/vehicles";
    }

    @Autowired
    public void setVehicleService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Autowired
    public void setVehicleTypeService(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }
}
