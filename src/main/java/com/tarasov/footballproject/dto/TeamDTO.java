package com.tarasov.footballproject.dto;

public class TeamDTO {
    private Integer teamId;
    private String teamName;
    private String teamCity;
    private String teamStadium;

    public TeamDTO(Integer teamId, String teamName, String teamCity, String teamStadium) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamCity = teamCity;
        this.teamStadium = teamStadium;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

    public String getTeamStadium() {
        return teamStadium;
    }

    public void setTeamStadium(String teamStadium) {
        this.teamStadium = teamStadium;
    }
}
