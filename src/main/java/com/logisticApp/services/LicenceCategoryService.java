package com.logisticApp.services;


import com.logisticApp.entities.EmployeeStatus;
import com.logisticApp.entities.LicenceCategory;
import com.logisticApp.repositories.LicenceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LicenceCategoryService {
    private LicenceCategoryRepository licenceCategoryRepository;

    public List<LicenceCategory> getAllLicenceCategories() {
        return licenceCategoryRepository.findAll();
    }

    public LicenceCategory findById(Long id) {
        Optional<LicenceCategory> optionalStatus = licenceCategoryRepository.findById(id);
        return optionalStatus.orElse(null);
    }

    @Autowired
    public void setLicenceCategoryRepository(LicenceCategoryRepository licenceCategoryRepository) {
        this.licenceCategoryRepository = licenceCategoryRepository;
    }
}
