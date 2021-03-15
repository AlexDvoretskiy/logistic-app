package com.logisticApp.controllers;


import com.logisticApp.dto.CalcPriceDto;
import com.logisticApp.dto.CalcRoutDto;
import com.logisticApp.services.PriceCalculator;
import com.logisticApp.services.RoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
public class CalcController {
    private RoutService routService;
    private PriceCalculator priceCalculator;


    @RequestMapping("/")
    public String calcPage(Model model) {
        List<String> citiesFrom = routService.getAllActiveCitiesFrom();
        List<String> citiesTo = routService.getAllActiveCitiesTo();

        model.addAttribute("calcRoutDto", new CalcRoutDto());
        model.addAttribute("citiesFrom", citiesFrom);
        model.addAttribute("citiesTo", citiesTo);

        return "calc-page";
    }

    @PostMapping("/calc")
    public String calculatePrice(@Valid @ModelAttribute("calcRoutDto") CalcRoutDto calcRoutDto, RedirectAttributes redirectAttributes, Model model) {
        CalcPriceDto calcPriceDto = priceCalculator.calculate(calcRoutDto);
        redirectAttributes.addFlashAttribute("calcPriceDto", calcPriceDto);
        return "redirect:/";
    }


    @Autowired
    public void setRoutService(RoutService routService) {
        this.routService = routService;
    }

    @Autowired
    public void setPriceCalculator(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }
}
