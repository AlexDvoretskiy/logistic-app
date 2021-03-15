package com.logisticApp.services;


import com.logisticApp.entities.Tariff;
import com.logisticApp.repositories.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TariffService {
    private TariffRepository tariffRepository;

    public List<Tariff> getAllActiveTariffs() {
       return tariffRepository.findAllByActiveTrue();
    }

    public Tariff getTariffByDistanceLimit(int distance) {
        Optional<Tariff> optionalTariff = tariffRepository.findTariffByDistance(distance);
        return optionalTariff.orElse(null);
    }

    @Autowired
    public void setTariffRepository(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }
}
