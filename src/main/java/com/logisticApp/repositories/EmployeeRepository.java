package com.logisticApp.repositories;


import com.logisticApp.entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findAllByActiveTrue();

    @Modifying(clearAutomatically = true)
    @Query(value = "update employees set active = 0 where id = ?1", nativeQuery = true)
    void setNotActive(Long id);

}
