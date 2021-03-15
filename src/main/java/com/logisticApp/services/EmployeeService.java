package com.logisticApp.services;

import com.logisticApp.dto.EmployeeDto;
import com.logisticApp.entities.Employee;
import com.logisticApp.entities.LicenceCategory;
import com.logisticApp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private EmployeeStatusService employeeStatusService;
    private LicenceCategoryService licenceCategoryService;


    public List<Employee> getAllActiveEmployees() {
        return employeeRepository.findAllByActiveTrue();
    }

    public EmployeeDto getEmployeeDtoByEmployeeId(Long id) {
        EmployeeDto employeeDto = new EmployeeDto();

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employeeDto.setEmpId(employee.getId());
            employeeDto.setFirstName(employee.getFirstName());
            employeeDto.setLastName(employee.getLastName());
            employeeDto.setMiddleName(employee.getMiddleName());
            employeeDto.setAge(employee.getAge());
            employeeDto.setStatusId(employee.getEmployeeStatus().getId());
        }
        return employeeDto;
    }

    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();

        employee.setFirstName(employeeDto.getFirstName());
        employee.setMiddleName(employeeDto.getMiddleName());
        employee.setLastName(employeeDto.getLastName());
        employee.setAge(employeeDto.getAge());
        employee.setEmployeeStatus(employeeStatusService.findById(employeeDto.getStatusId()));
        employee.setLicenceCategoryList(getLicenceListFromDto(employeeDto));
        employee.setHireDate(getHireDateFromDto(employeeDto));

        employeeRepository.save(employee);
    }

    public void updateEmployee(EmployeeDto employeeDto, Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            employee.setLastName(employeeDto.getLastName());
            employee.setFirstName(employeeDto.getFirstName());
            employee.setMiddleName(employeeDto.getMiddleName());
            employee.setAge(employeeDto.getAge());
            employee.setEmployeeStatus(employeeStatusService.findById(employeeDto.getStatusId()));
            employee.setLicenceCategoryList(getLicenceListFromDto(employeeDto));

            employeeRepository.save(employee);
        }
    }

    private Date getHireDateFromDto(EmployeeDto employeeDto) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(employeeDto.getHireDate());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<LicenceCategory> getLicenceListFromDto(EmployeeDto employeeDto) {
        List<LicenceCategory> licenceCategories = new LinkedList<>();

        for (Long id : employeeDto.getLicenceIdList()) {
            LicenceCategory licenceCategory = licenceCategoryService.findById(id);
            licenceCategories.add(licenceCategory);
        }
        return licenceCategories;
    }

    @Transactional
    public void removeEmployee(Long id) {
        employeeRepository.setNotActive(id);
    }


    @Autowired
    public void setEmployeeStatusService(EmployeeStatusService employeeStatusService) {
        this.employeeStatusService = employeeStatusService;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    public void setLicenceCategoryService(LicenceCategoryService licenceCategoryService) {
        this.licenceCategoryService = licenceCategoryService;
    }
}
