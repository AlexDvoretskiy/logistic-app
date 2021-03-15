package com.logisticApp.services;


import com.logisticApp.entities.VehicleType;
import com.logisticApp.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VehicleTypeService {
    private VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> getAllVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }

    public VehicleType findById(Long id) {
        Optional<VehicleType> optionalVehicleType = vehicleTypeRepository.findById(id);
        return optionalVehicleType.orElse(null);
    }

    @Autowired
    public void setVehicleTypeRepository(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }
}
