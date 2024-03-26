package com.tarasov.footballproject.dto.post;

public class PostTeamDTO {
    private String teamName;
    private String teamCity;
    private String teamStadium;

    public PostTeamDTO(String teamName, String teamCity, String teamStadium) {
        this.teamName = teamName;
        this.teamCity = teamCity;
        this.teamStadium = teamStadium;
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
