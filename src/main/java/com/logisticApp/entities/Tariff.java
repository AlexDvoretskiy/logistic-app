package com.logisticApp.entities;


import javax.persistence.*;

@Entity
@Table(name = "tariffs")
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dist_limit")
    private int distanceLimit;

    @Column(name = "cost_per_km")
    private double costPerKilometer;

    @Column(name = "max_volume")
    private double maxVolume;

    @Column(name = "extra_volume_cost")
    private double extraVolumeCost;

    @Column(name = "fragile_coeff")
    private double fragileCoefficient;

    @Column(name = "active")
    private boolean active = true;

    public Tariff() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDistanceLimit() {
        return distanceLimit;
    }

    public void setDistanceLimit(int distanceLimit) {
        this.distanceLimit = distanceLimit;
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

    public double getFragileCoefficient() {
        return fragileCoefficient;
    }

    public void setFragileCoefficient(double fragileCoefficient) {
        this.fragileCoefficient = fragileCoefficient;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
