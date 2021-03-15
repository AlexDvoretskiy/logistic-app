package com.logisticApp.services;


import com.logisticApp.dto.CalcRoutDto;
import com.logisticApp.dto.CalcPriceDto;
import com.logisticApp.entities.Rout;
import com.logisticApp.entities.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PriceCalculator {
    private RoutService routService;
    private TariffService tariffService;


    public CalcPriceDto calculate(CalcRoutDto calcRoutDto) {
        Rout rout = routService.getRoutByCityFromAndCityTo(calcRoutDto.getCityFrom(), calcRoutDto.getCityTo());
        Tariff tariff = tariffService.getTariffByDistanceLimit(rout.getDistance());

        CalcPriceDto calcPriceDto = new CalcPriceDto();
        calcPriceDto.setDistance(rout.getDistance());
        calcPriceDto.setCostPerKilometer(tariff.getCostPerKilometer());
        calcPriceDto.setMaxVolume(tariff.getMaxVolume());
        calcPriceDto.setExtraVolumeCost(tariff.getExtraVolumeCost());
        calcPriceDto.setTotalPrice(calculateTotalPrice(tariff, rout, calcRoutDto));
        calcPriceDto.setFragile(calcRoutDto.isFragile());
        calcPriceDto.setFragileCoefficient(tariff.getFragileCoefficient());

        return calcPriceDto;
    }

    private double calculateTotalPrice(Tariff tariff, Rout rout, CalcRoutDto calcRoutDto) {
        double totalPrice = tariff.getCostPerKilometer() * rout.getDistance() * calcRoutDto.getCargoWeight();
        if (calcRoutDto.getCargoVolume() > tariff.getMaxVolume()) {
            totalPrice = totalPrice + (calcRoutDto.getCargoVolume() - tariff.getMaxVolume()) * tariff.getExtraVolumeCost();
        }
        if (calcRoutDto.isFragile()) {
            totalPrice = totalPrice * tariff.getFragileCoefficient();
        }
        return totalPrice;
    }


    @Autowired
    public void setRoutService(RoutService routService) {
        this.routService = routService;
    }

    @Autowired
    public void setTariffService(TariffService tariffService) {
        this.tariffService = tariffService;
    }
}
