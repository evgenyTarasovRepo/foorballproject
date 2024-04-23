package com.tarasov.footballproject.dto.get;

import java.sql.Date;

public class GetScorersGTO {
    private String firstName;
    private String lastName;
    private Integer playerNumber;
    private String position;
    private String teamName;
    private Integer scoresQuantity;

    public GetScorersGTO(String firstName, String lastName, Integer playerNumber, String position, String teamName, Integer scoresQuantity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.playerNumber = playerNumber;
        this.position = position;
        this.teamName = teamName;
        this.scoresQuantity = scoresQuantity;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getScoresQuantity() {
        return scoresQuantity;
    }

    public void setScoresQuantity(Integer scoresQuantity) {
        this.scoresQuantity = scoresQuantity;
    }
}
