package com.tarasov.footballproject.dto.get;

import java.time.LocalDateTime;
import java.util.List;

public class GetMatchDTO {
    private Integer integer;
    LocalDateTime matchDateTime;
    private String homeTeam;
    private List<String> homeTeamPlayers;
    private String awayTeam;
    private List<String> awayTeamPlayers;
    private String stadium;
    private Integer homeTeamScore;
    private Integer awayTeamScore;
    private Integer attendance;

    public GetMatchDTO() {
    }

    public GetMatchDTO(Integer integer, LocalDateTime matchDateTime,
                       String homeTeam, List<String> homeTeamPlayers,
                       String awayTeam, List<String> awayTeamPlayers,
                       String stadium, Integer homeTeamScore,
                       Integer awayTeamScore, Integer attendance) {
        this.integer = integer;
        this.matchDateTime = matchDateTime;
        this.homeTeam = homeTeam;
        this.homeTeamPlayers = homeTeamPlayers;
        this.awayTeam = awayTeam;
        this.awayTeamPlayers = awayTeamPlayers;
        this.stadium = stadium;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.attendance = attendance;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public LocalDateTime getMatchDateTime() {
        return matchDateTime;
    }

    public void setMatchDateTime(LocalDateTime matchDateTime) {
        this.matchDateTime = matchDateTime;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public List<String> getHomeTeamPlayers() {
        return homeTeamPlayers;
    }

    public void setHomeTeamPlayers(List<String> homeTeamPlayers) {
        this.homeTeamPlayers = homeTeamPlayers;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public List<String> getAwayTeamPlayers() {
        return awayTeamPlayers;
    }

    public void setAwayTeamPlayers(List<String> awayTeamPlayers) {
        this.awayTeamPlayers = awayTeamPlayers;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
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
}
