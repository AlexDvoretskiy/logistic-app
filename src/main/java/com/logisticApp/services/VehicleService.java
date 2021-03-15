package com.logisticApp.services;


import com.logisticApp.dto.VehicleDto;
import com.logisticApp.entities.Vehicle;
import com.logisticApp.entities.VehicleType;
import com.logisticApp.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class VehicleService {
    private VehicleRepository vehicleRepository;
    private VehicleTypeService vehicleTypeService;


    public List<Vehicle> getAllActiveVehicle() {
        return vehicleRepository.findAllByActiveTrue();
    }

    public VehicleDto getVehicleDtoByVehicleId(Long id) {
        VehicleDto vehicleDto = new VehicleDto();

        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (optionalVehicle.isPresent()) {
            Vehicle vehicle = optionalVehicle.get();
            vehicleDto.setVehicleId(vehicle.getId());
            vehicleDto.setTitle(vehicle.getTitle());
            vehicleDto.setTonnage(vehicle.getTonnage());
            vehicleDto.setHorsepower(vehicle.getHorsepower());
            vehicleDto.setManufactureYear(vehicle.getManufactureYear());
            vehicleDto.setVehicleTypeId(vehicle.getVehicleType().getId());
        }
        return vehicleDto;
    }

    public void saveVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();

        vehicle.setTitle(vehicleDto.getTitle());
        vehicle.setTonnage(vehicleDto.getTonnage());
        vehicle.setHorsepower(vehicleDto.getHorsepower());
        vehicle.setManufactureYear(vehicleDto.getManufactureYear());
        vehicle.setVehicleType(getVehicleTypeFromDto(vehicleDto));

        vehicleRepository.save(vehicle);
    }

    public void updateVehicle(VehicleDto vehicleDto, Long id) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (optionalVehicle.isPresent()) {
            Vehicle vehicle = optionalVehicle.get();

            vehicle.setTitle(vehicleDto.getTitle());
            vehicle.setTonnage(vehicleDto.getTonnage());
            vehicle.setManufactureYear(vehicleDto.getManufactureYear());
            vehicle.setHorsepower(vehicleDto.getHorsepower());
            vehicle.setVehicleType(vehicleTypeService.findById(vehicleDto.getVehicleTypeId()));

            vehicleRepository.save(vehicle);
        }
    }

    private VehicleType getVehicleTypeFromDto(VehicleDto vehicleDto) {
        return vehicleTypeService.findById(vehicleDto.getVehicleTypeId());
    }

    @Transactional
    public void removeVehicle(Long id) {
        vehicleRepository.setNotActive(id);
    }


    @Autowired
    public void setVehicleRepository(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Autowired
    public void setVehicleTypeRepository(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }
}
