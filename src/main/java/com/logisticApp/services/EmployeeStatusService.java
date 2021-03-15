package com.logisticApp.services;


import com.logisticApp.entities.EmployeeStatus;
import com.logisticApp.repositories.EmployeeStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeStatusService {
    private EmployeeStatusRepository employeeStatusRepository;

    @Autowired
    public void setEmployeeStatusService(EmployeeStatusRepository employeeStatusRepository) {
        this.employeeStatusRepository = employeeStatusRepository;
    }

    public List<EmployeeStatus> getAllEmployeeStatuses() {
        return employeeStatusRepository.findAll();
    }

    public EmployeeStatus findById(Long id) {
        Optional<EmployeeStatus> optionalStatus = employeeStatusRepository.findById(id);
        return optionalStatus.orElse(null);
    }
}
