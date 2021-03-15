package com.logisticApp.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class RoutDto {

    private Long routId;

    @NotNull(message = "Данное поле должно быть заполнено")
    @Size(min = 1, message = "Данное поле должно быть заполнено")
    private String cityFrom;

    @NotNull(message = "Данное поле должно быть заполнено")
    @Size(min = 1, message = "Данное поле должно быть заполнено")
    private String cityTo;

    @Min(1)
    @NotNull(message = "Данное поле должно быть заполнено")
    private int distance;

    public RoutDto() {

    }

    public Long getRoutId() {
        return routId;
    }

    public void setRoutId(Long routId) {
        this.routId = routId;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
