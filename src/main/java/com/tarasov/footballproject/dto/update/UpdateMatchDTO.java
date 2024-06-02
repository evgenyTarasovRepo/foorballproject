package com.tarasov.footballproject.dto.update;

import java.time.LocalDateTime;

public class UpdateMatchDTO {
    private LocalDateTime matchDateTime;
    private String homeTeam;
    private String awayTeam;
    private String stadium;
    private Integer attendance;

    public UpdateMatchDTO() {
    }

    public UpdateMatchDTO(LocalDateTime matchDateTime, String homeTeam, String awayTeam, String stadium, Integer attendance) {
        this.matchDateTime = matchDateTime;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stadium = stadium;
        this.attendance = attendance;
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

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }
}
