package com.logisticApp.repositories;


import com.logisticApp.entities.Rout;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface RoutRepository extends CrudRepository<Rout, Long> {

    List<Rout> findAllByActiveTrue();

    Optional<Rout> findByCityFromAndCityToAndActiveTrue(String cityFrom, String cityTo);

    @Query(value = "select distinct city_from from routs where active is true", nativeQuery = true)
    List<String> getAllActiveCityFrom();

    @Query(value = "select distinct city_to from routs where active is true", nativeQuery = true)
    List<String> getAllActiveCityTo();

    @Modifying(clearAutomatically = true)
    @Query(value = "update routs set active = 0 where id = ?1", nativeQuery = true)
    void setNotActive(Long id);

}
