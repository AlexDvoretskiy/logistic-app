package com.logisticApp.controllers;


import com.logisticApp.dto.EmployeeDto;
import com.logisticApp.entities.EmployeeStatus;
import com.logisticApp.entities.LicenceCategory;
import com.logisticApp.services.EmployeeService;
import com.logisticApp.services.EmployeeStatusService;
import com.logisticApp.services.LicenceCategoryService;
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
@RequestMapping("/editEmployee")
public class EditEmployeeController {
    private EmployeeService employeeService;
    private EmployeeStatusService employeeStatusService;
    private LicenceCategoryService licenceCategoryService;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("")
    public String addStuffPage(Model model) {
        List<LicenceCategory> licenceCategoryList = licenceCategoryService.getAllLicenceCategories();
        List<EmployeeStatus> employeeStatusList = employeeStatusService.getAllEmployeeStatuses();

        model.addAttribute("licenceCategories", licenceCategoryList);
        model.addAttribute("employeeStatuses", employeeStatusList);
        model.addAttribute("employeeDto", new EmployeeDto());

        return "add-emp-page";
    }

    @PostMapping("/add")
    public String addEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            List<LicenceCategory> licenceCategoryList = licenceCategoryService.getAllLicenceCategories();
            List<EmployeeStatus> employeeStatusList = employeeStatusService.getAllEmployeeStatuses();

            model.addAttribute("licenceCategories", licenceCategoryList);
            model.addAttribute("employeeStatuses", employeeStatusList);

            return "add-emp-page";
        }
        employeeService.saveEmployee(employeeDto);
        return "redirect:/staff";
    }

    @GetMapping("/change/{id}")
    public String editEmployeePage(@PathVariable(name = "id") Long id, Model model) {
        List<LicenceCategory> licenceCategoryList = licenceCategoryService.getAllLicenceCategories();
        List<EmployeeStatus> employeeStatusList = employeeStatusService.getAllEmployeeStatuses();
        EmployeeDto employeeDto = employeeService.getEmployeeDtoByEmployeeId(id);

        model.addAttribute("licenceCategories", licenceCategoryList);
        model.addAttribute("employeeStatuses", employeeStatusList);
        model.addAttribute("employeeDto", employeeDto);

        return "edit-emp-page";
    }

    @PostMapping("/change/{id}")
    public String changeEmployeeById(@ModelAttribute("employeeDto") EmployeeDto employeeDto, @PathVariable(name = "id") Long id) {
        employeeService.updateEmployee(employeeDto, id);
        return "redirect:/staff";
    }


    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setEmployeeStatusService(EmployeeStatusService employeeStatusService) {
        this.employeeStatusService = employeeStatusService;
    }

    @Autowired
    public void setLicenceCategoryService(LicenceCategoryService licenceCategoryService) {
        this.licenceCategoryService = licenceCategoryService;
    }
}
