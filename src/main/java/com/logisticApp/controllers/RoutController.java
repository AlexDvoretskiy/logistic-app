package com.logisticApp.controllers;


import com.logisticApp.entities.Rout;
import com.logisticApp.services.RoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/routs")
public class RoutController {
    private RoutService routService;

    @GetMapping("")
    public String routPage(Model model) {
        List<Rout> routList = routService.getAllActiveRouts();
        model.addAttribute("routs", routList);
        return "rout-page";
    }

    @GetMapping("/remove/{id}")
    public String removeEmployeeById(@PathVariable(name = "id") Long id, Model model) {
        routService.removeRout(id);
        return "redirect:/routs";
    }

    @Autowired
    public void setRoutService(RoutService routService) {
        this.routService = routService;
    }
}
