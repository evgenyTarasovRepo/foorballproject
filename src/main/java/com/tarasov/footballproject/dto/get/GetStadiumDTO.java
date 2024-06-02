package com.tarasov.footballproject.dto.get;

public class GetStadiumDTO {
    private Integer id;
    private String stadiumName;
    private Integer capacity;
    private String city;

    public GetStadiumDTO(Integer id, String stadiumName, Integer capacity, String city) {
        this.id = id;
        this.stadiumName = stadiumName;
        this.capacity = capacity;
        this.city = city;
    }

    public GetStadiumDTO() {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
