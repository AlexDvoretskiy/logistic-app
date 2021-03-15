package com.logisticApp.controllers;


import com.logisticApp.dto.EmployeeDto;
import com.logisticApp.entities.Employee;
import com.logisticApp.entities.EmployeeStatus;
import com.logisticApp.entities.LicenceCategory;
import com.logisticApp.services.EmployeeService;
import com.logisticApp.services.EmployeeStatusService;
import com.logisticApp.services.LicenceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/staff")
public class EmployeeController {
    private EmployeeService employeeService;
    private EmployeeStatusService employeeStatusService;
    private LicenceCategoryService licenceCategoryService;


    @GetMapping("")
    public String staffPage(Model model) {
        List<LicenceCategory> licenceCategoryList = licenceCategoryService.getAllLicenceCategories();
        List<EmployeeStatus> employeeStatusList = employeeStatusService.getAllEmployeeStatuses();
        List<Employee> employeeList = employeeService.getAllActiveEmployees();

        model.addAttribute("licenceCategories", licenceCategoryList);
        model.addAttribute("employeeStatuses", employeeStatusList);
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("employees", employeeList);
        
        return "staff-page";
    }

    @GetMapping("/remove/{id}")
    public String removeEmployeeById(@PathVariable(name = "id") Long id, Model model) {
        employeeService.removeEmployee(id);
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
