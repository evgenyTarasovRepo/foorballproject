package com.tarasov.footballproject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    @Column(name = "date_time")
    LocalDateTime matchDateTime;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "stadium_id")
    private Stadium homeStadium;

    @Column(name = "attendance")
    private Integer attendance;

    @Column(name = "completed")
    private Boolean isCompleted;
    @Formula("(SELECT count(*) " +
            "FROM goals g " +
            "join players p " +
            "on g.p_id = p.p_id " +
            "join teams t " +
            "on p.team_id = t.team_id " +
            "where g.match_id = match_id and " +
            "t.team_id = home_team_id)")
    private Integer homeTeamScore;

    @Formula("(SELECT count(*) " +
            "FROM goals g " +
            "join players p " +
            "on g.p_id = p.p_id " +
            "join teams t " +
            "on p.team_id = t.team_id " +
            "where g.match_id = match_id and " +
            "t.team_id = away_team_id)")
    private Integer awayTeamScore;



    public Match() {
    }

    public Match(LocalDateTime matchDateTime, Team homeTeam, Team awayTeam, Stadium homeStadium, Integer attendance) {
        this.matchDateTime = matchDateTime;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeStadium = homeStadium;
        this.attendance = attendance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getMatchDateTime() {
        return matchDateTime;
    }

    public void setMatchDateTime(LocalDateTime matchDateTime) {
        this.matchDateTime = matchDateTime;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Stadium getHomeStadium() {
        return homeStadium;
    }

    public void setHomeStadium(Stadium homeStadium) {
        this.homeStadium = homeStadium;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(Integer awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
