package com.logisticApp.dto;


public class CalcRoutDto {
    private String cityFrom;
    private String cityTo;
    private double cargoWeight;
    private double cargoVolume;
    private boolean fragile;

    public CalcRoutDto() {

    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public double getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(double cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    public boolean isFragile() {
        return fragile;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }
}
