package com.tarasov.footballproject.dto.post;

import com.tarasov.footballproject.entities.Team;

import java.sql.Date;

public class PostPlayerDTO {
    private String firstName;
    private String lastName;
    private String nationality;
    private Date dob;
    private Integer playerNumber;
    private String position;
    private String teamName;

    public PostPlayerDTO(String firstName, String lastName, String nationality, Date dob, Integer playerNumber, String position, String teamName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.dob = dob;
        this.playerNumber = playerNumber;
        this.position = position;
        this.teamName = teamName;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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
}
