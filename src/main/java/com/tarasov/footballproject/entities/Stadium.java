package com.tarasov.footballproject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "stadiums")
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private Integer id;

    @Column(name = "s_name")
    private String stadiumName;

    @Column(name = "capacity")
    private Integer capacity;

//    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    public Stadium() {
    }

    public Stadium(String stadiumName, Integer capacity) {
        this.stadiumName = stadiumName;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {

        this.city = city;
    }

    @Override
    public String toString() {
        return "Stadium{" +
                "id=" + id +
                ", stadiumName='" + stadiumName + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
