package com.logisticApp.repositories;


import com.logisticApp.entities.EmployeeStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeStatusRepository extends CrudRepository<EmployeeStatus, Long> {

    List<EmployeeStatus> findAll();

    Optional<EmployeeStatus> findById(Long id);
}
