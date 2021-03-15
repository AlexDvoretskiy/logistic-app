package com.logisticApp.dto;


public class CalcPriceDto {
    private int distance;
    private double costPerKilometer;
    private double maxVolume;
    private double extraVolumeCost;
    private double totalPrice;
    private double fragileCoefficient;
    private boolean fragile;

    public CalcPriceDto() {

    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getCostPerKilometer() {
        return costPerKilometer;
    }

    public void setCostPerKilometer(double costPerKilometer) {
        this.costPerKilometer = costPerKilometer;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public double getExtraVolumeCost() {
        return extraVolumeCost;
    }

    public void setExtraVolumeCost(double extraVolumeCost) {
        this.extraVolumeCost = extraVolumeCost;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getFragileCoefficient() {
        return fragileCoefficient;
    }

    public void setFragileCoefficient(double fragileCoefficient) {
        this.fragileCoefficient = fragileCoefficient;
    }

    public boolean isFragile() {
        return fragile;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }
}
