package com.logisticApp.entities;


import javax.persistence.*;


@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "tonnage")
    private String tonnage;

    @Column(name = "horsepower")
    private short horsepower;

    @Column(name = "manufacture_year")
    private short manufactureYear;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private VehicleType vehicleType;

    @Column(name = "active")
    private boolean active = true;


    public Vehicle() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTonnage() {
        return tonnage;
    }

    public void setTonnage(String tonnage) {
        this.tonnage = tonnage;
    }

    public short getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(short horsepower) {
        this.horsepower = horsepower;
    }

    public short getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(short manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
