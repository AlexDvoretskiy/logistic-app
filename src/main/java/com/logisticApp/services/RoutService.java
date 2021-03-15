package com.logisticApp.services;


import com.logisticApp.dto.RoutDto;
import com.logisticApp.entities.Rout;
import com.logisticApp.repositories.RoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class RoutService {
    private RoutRepository routRepository;

    public List<Rout> getAllActiveRouts() {
        return routRepository.findAllByActiveTrue();
    }

    public RoutDto getRoutDtoByRoutId(Long id) {
        RoutDto routDto = new RoutDto();

        Optional<Rout> optionalRout = routRepository.findById(id);
        if (optionalRout.isPresent()) {
            Rout rout = optionalRout.get();
            routDto.setRoutId(rout.getId());
            routDto.setCityFrom(rout.getCityFrom());
            routDto.setCityTo(rout.getCityTo());
            routDto.setDistance(rout.getDistance());
        }
        return routDto;
    }

    public void saveRout(RoutDto routDto) {
        Rout rout = new Rout();

        rout.setCityFrom(routDto.getCityFrom());
        rout.setCityTo(routDto.getCityTo());
        rout.setDistance(routDto.getDistance());

        routRepository.save(rout);
    }

    public void updateRout(RoutDto routDto, Long id) {
        Optional<Rout> optionalRout = routRepository.findById(id);
        if (optionalRout.isPresent()) {
            Rout rout = optionalRout.get();

            rout.setCityFrom(routDto.getCityFrom());
            rout.setCityTo(routDto.getCityTo());
            rout.setDistance(routDto.getDistance());

            routRepository.save(rout);
        }
    }

    public Rout getRoutByCityFromAndCityTo(String cityFrom, String cityTo) {
        Optional<Rout> optionalRout = routRepository.findByCityFromAndCityToAndActiveTrue(cityFrom, cityTo);
        return optionalRout.orElse(null);
    }

    public List<String> getAllActiveCitiesFrom() {
        return routRepository.getAllActiveCityFrom();
    }

    public List<String> getAllActiveCitiesTo() {
        return routRepository.getAllActiveCityTo();
    }

    @Transactional
    public void removeRout(Long id) {
        routRepository.setNotActive(id);
    }

    @Autowired
    public void setRoutRepository(RoutRepository routRepository) {
        this.routRepository = routRepository;
    }
}
