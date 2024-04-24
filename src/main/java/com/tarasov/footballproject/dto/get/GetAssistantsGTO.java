package com.tarasov.footballproject.dto.get;

public class GetAssistantsGTO {
    private String firstName;
    private String lastName;
    private Integer playerNumber;
    private String teamName;
    private Integer assistsQuantity;

    public GetAssistantsGTO(String firstName, String lastName, Integer playerNumber, String teamName, Integer assistsQuantity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.playerNumber = playerNumber;
        this.teamName = teamName;
        this.assistsQuantity = assistsQuantity;
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getAssistsQuantity() {
        return assistsQuantity;
    }

    public void setAssistsQuantity(Integer assistsQuantity) {
        this.assistsQuantity = assistsQuantity;
    }
}
