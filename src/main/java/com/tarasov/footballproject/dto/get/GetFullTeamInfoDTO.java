package com.tarasov.footballproject.dto.get;

import com.tarasov.footballproject.entities.Player;

import java.util.List;

public class GetFullTeamInfoDTO {
    private Integer id;
    private String team;
    private String manager;
    private String city;
    private String stadium;
    private List<Player> players;

    public GetFullTeamInfoDTO() {
    }

    public GetFullTeamInfoDTO(Integer id, String team, String manager, String city, String stadium, List<Player> players) {
        this.id = id;
        this.team = team;
        this.manager = manager;
        this.city = city;
        this.stadium = stadium;
        this.players = players;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
