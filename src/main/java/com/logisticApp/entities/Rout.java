package com.logisticApp.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "routs")
public class Rout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city_from")
    private String cityFrom;

    @Column(name = "city_to")
    private String cityTo;

    @Column(name = "distance")
    private int distance;

    @Column(name = "active")
    private boolean active = true;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt = new Date();


    public Rout() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
