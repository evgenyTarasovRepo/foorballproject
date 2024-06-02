package com.tarasov.footballproject.dto.update;

public class UpdateGoalDTO {
    private String scoredPlayerName;
    private String AssistedPlayerName;
    private Integer goalMinute;
    private Integer matchId;

    public UpdateGoalDTO(String scoredPlayerName, String assistedPlayerName, Integer goalMinute, Integer matchId) {
        this.scoredPlayerName = scoredPlayerName;
        AssistedPlayerName = assistedPlayerName;
        this.goalMinute = goalMinute;
        this.matchId = matchId;
    }

    public UpdateGoalDTO() {
    }

    public String getScoredPlayerName() {
        return scoredPlayerName;
    }

    public void setScoredPlayerName(String scoredPlayerName) {
        this.scoredPlayerName = scoredPlayerName;
    }

    public String getAssistedPlayerName() {
        return AssistedPlayerName;
    }

    public void setAssistedPlayerName(String assistedPlayerName) {
        AssistedPlayerName = assistedPlayerName;
    }

    public Integer getGoalMinute() {
        return goalMinute;
    }

    public void setGoalMinute(Integer goalMinute) {
        this.goalMinute = goalMinute;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }
}
