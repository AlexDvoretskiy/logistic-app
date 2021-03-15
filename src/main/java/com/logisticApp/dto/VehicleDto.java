package com.logisticApp.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VehicleDto {

    private Long vehicleId;

    @NotNull(message = "Данное поле должно быть заполнено")
    @Size(min = 1, message = "Данное поле должно быть заполнено")
    private String title;

    @NotNull(message = "Данное поле должно быть заполнено")
    @Size(min = 1, message = "Данное поле должно быть заполнено")
    private String tonnage;

    @Min(50)
    @NotNull(message = "Данное поле должно быть заполнено")
    private short horsepower;

    @Min(1999)
    @NotNull(message = "Данное поле должно быть заполнено")
    private short manufactureYear;

    @NotNull(message = "Данное поле должно быть заполнено")
    private Long vehicleTypeId;

    public VehicleDto() {

    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
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

    public Long getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Long vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }
}
