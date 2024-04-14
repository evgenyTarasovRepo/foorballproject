package com.tarasov.footballproject.dto.get;

public class GetGoalDTO {
    private Integer goalId;
    private String scoredPlayerName;
    private String assistedPlayerName;
    private Integer goalMinute;
    private String match;

    public GetGoalDTO() {
    }

    public GetGoalDTO(Integer goalId, String scoredPlayerName, String assistedPlayerName, Integer goalMinute, String match) {
        this.goalId = goalId;
        this.scoredPlayerName = scoredPlayerName;
        this.assistedPlayerName = assistedPlayerName;
        this.goalMinute = goalMinute;
        this.match = match;
    }

    public Integer getGoalId() {
        return goalId;
    }

    public void setGoalId(Integer goalId) {
        this.goalId = goalId;
    }

    public String getScoredPlayerName() {
        return scoredPlayerName;
    }

    public void setScoredPlayerName(String scoredPlayerName) {
        this.scoredPlayerName = scoredPlayerName;
    }

    public String getAssistedPlayerName() {
        return assistedPlayerName;
    }

    public void setAssistedPlayerName(String assistedPlayerName) {
        this.assistedPlayerName = assistedPlayerName;
    }

    public Integer getGoalMinute() {
        return goalMinute;
    }

    public void setGoalMinute(Integer goalMinute) {
        this.goalMinute = goalMinute;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }
}
