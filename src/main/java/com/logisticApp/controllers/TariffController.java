package com.logisticApp.controllers;


import com.logisticApp.entities.Tariff;
import com.logisticApp.services.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/tariffs")
public class TariffController {
    private TariffService tariffService;

    @GetMapping("")
    public String tariffPage(Model model) {
        List<Tariff> tariffList = tariffService.getAllActiveTariffs();
        model.addAttribute("tariffs", tariffList);
        return "tariff-page";
    }

    @Autowired
    public void setTariffService(TariffService tariffService) {
        this.tariffService = tariffService;
    }
}
