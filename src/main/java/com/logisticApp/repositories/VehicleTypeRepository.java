package com.logisticApp.repositories;

import com.logisticApp.entities.VehicleType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface VehicleTypeRepository extends CrudRepository<VehicleType, Long> {

    List<VehicleType> findAll();

    Optional<VehicleType> findById(Long id);
}
