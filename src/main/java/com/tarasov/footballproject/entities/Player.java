package com.tarasov.footballproject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "nationality")
    private String nationality;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(name = "dob")
    private Date dob;

    @Column(name = "t_short_num")
    private Integer playerNumber;

    @Column(name = "position")
    private String position;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
    
    @Formula("(select count(*) from goals g where g.p_id = p_id)")
    private Integer playerGoals;

    @Formula("(select count(*) from goals g where g.a_id = p_id)")
    private Integer playerAssists;
    public Player() {
    }

    public Player(String firstName, String lastName, String nationality, Date dob, Integer playerNumber, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.dob = dob;
        this.playerNumber = playerNumber;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getPlayerGoals() {
        return playerGoals;
    }

    public void setPlayerGoals(Integer playerGoals) {
        this.playerGoals = playerGoals;
    }

    public Integer getPlayerAssists() {
        return playerAssists;
    }

    public void setPlayerAssists(Integer playerAssists) {
        this.playerAssists = playerAssists;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dob=" + dob +
                ", playerNumber='" + playerNumber + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
