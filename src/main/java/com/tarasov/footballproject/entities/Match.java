package com.tarasov.footballproject.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Integer id;

    @Column(name = "date_time")
    LocalDateTime matchDateTime;

    @Column(name = "home_team_id")
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @Column(name = "away_team_id")
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;

    @Column(name = "stadium_id")
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    @Column(name = "ht_score")
    private Integer homeTEamScore;

    @Column(name = "at_score")
    private Integer awayTeamScore;

    @Column(name = "attendance")
    private Integer attendance;

    public Match() {
    }

    public Match(LocalDateTime matchDateTime, Team homeTeam, Team awayTeam, Stadium stadium, Integer homeTEamScore, Integer awayTeamScore, Integer attendance) {
        this.matchDateTime = matchDateTime;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stadium = stadium;
        this.homeTEamScore = homeTEamScore;
        this.awayTeamScore = awayTeamScore;
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

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Integer getHomeTEamScore() {
        return homeTEamScore;
    }

    public void setHomeTEamScore(Integer homeTEamScore) {
        this.homeTEamScore = homeTEamScore;
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

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", matchDateTime=" + matchDateTime +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", stadium=" + stadium +
                ", homeTEamScore=" + homeTEamScore +
                ", awayTeamScore=" + awayTeamScore +
                ", attendance=" + attendance +
                '}';
    }
}
