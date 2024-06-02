package com.tarasov.footballproject.dto.get;

import java.util.List;

public class GetCityDTO {
    private Integer id;
    private String cityName;
    private List<String> stadiums;
    private List<Integer> stadiumsCapacity;

    public GetCityDTO(Integer id, String cityName, List<String> stadiums, List<Integer> stadiumsCapacity) {
        this.id = id;
        this.cityName = cityName;
        this.stadiums = stadiums;
        this.stadiumsCapacity = stadiumsCapacity;
    }

    public GetCityDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<String> getStadiums() {
        return stadiums;
    }

    public void setStadiums(List<String> stadiums) {
        this.stadiums = stadiums;
    }

    public List<Integer> getStadiumsCapacity() {
        return stadiumsCapacity;
    }

    public void setStadiumsCapacity(List<Integer> stadiumsCapacity) {
        this.stadiumsCapacity = stadiumsCapacity;
    }
}
