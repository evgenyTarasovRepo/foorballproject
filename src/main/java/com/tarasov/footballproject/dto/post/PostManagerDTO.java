package com.tarasov.footballproject.dto.post;

import java.sql.Date;

public class PostManagerDTO {
    private String firstName;
    private String lastName;
    private String nationality;
    private Date dob;
    private String teamName;

    public PostManagerDTO(String firstName, String lastName, String nationality, Date dob, String teamName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.dob = dob;
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
