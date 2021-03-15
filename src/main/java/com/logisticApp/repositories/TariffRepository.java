package com.logisticApp.repositories;

import com.logisticApp.entities.Tariff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TariffRepository extends CrudRepository<Tariff, Long> {

    List<Tariff> findAllByActiveTrue();

    @Query(value = "select * from tariffs where dist_limit = (select min(dist_limit) from tariffs where ?1 between 0 and dist_limit)", nativeQuery = true)
    Optional<Tariff> findTariffByDistance(int distance);
}
