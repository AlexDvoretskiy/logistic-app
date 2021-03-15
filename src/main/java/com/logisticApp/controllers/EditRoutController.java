package com.logisticApp.controllers;


import com.logisticApp.dto.RoutDto;
import com.logisticApp.services.RoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/editRout")
public class EditRoutController {
    private RoutService routService;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("")
    public String addRoutPage(Model model) {
        model.addAttribute("routDto", new RoutDto());
        return "add-rout-page";
    }

    @PostMapping("/add")
    public String addRout(@Valid @ModelAttribute("routDto") RoutDto routDto, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            return "add-rout-page";
        }
        routService.saveRout(routDto);
        return "redirect:/routs";
    }

    @GetMapping("/change/{id}")
    public String editRoutPage(@PathVariable(name = "id") Long id, Model model) {
        RoutDto routDto = routService.getRoutDtoByRoutId(id);
        model.addAttribute("routDto", routDto);
        return "edit-rout-page";
    }

    @PostMapping("/change/{id}")
    public String changeRoutById(@ModelAttribute("employeeDto") RoutDto routDto, @PathVariable(name = "id") Long id, Model model) {
        routService.updateRout(routDto, id);
        return "redirect:/routs";
    }


    @Autowired
    public void setRoutService(RoutService routService) {
        this.routService = routService;
    }
}
