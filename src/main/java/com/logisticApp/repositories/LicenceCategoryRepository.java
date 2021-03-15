package com.logisticApp.repositories;


import com.logisticApp.entities.LicenceCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LicenceCategoryRepository extends CrudRepository<LicenceCategory, Long> {

    List<LicenceCategory> findAll();

    Optional<LicenceCategory> findById(Long id);
}
