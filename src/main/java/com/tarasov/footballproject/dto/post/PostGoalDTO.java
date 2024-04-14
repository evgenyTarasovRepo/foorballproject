package com.tarasov.footballproject.dto.post;

public class PostGoalDTO {
    private String playerScoredName;
    private String playerScoredLastName;
    private String playerAssistedName;
    private String playerAssistedLastName;
    private Integer goalMinute;
    private Integer matchId;

    public PostGoalDTO() {
    }

    public PostGoalDTO(String playerScoredName, String playerScoredLastName, String playerAssistedName, String playerAssistedLastName, Integer goalMinute, Integer matchId) {
        this.playerScoredName = playerScoredName;
        this.playerScoredLastName = playerScoredLastName;
        this.playerAssistedName = playerAssistedName;
        this.playerAssistedLastName = playerAssistedLastName;
        this.goalMinute = goalMinute;
        this.matchId = matchId;
    }

    public String getPlayerScoredName() {
        return playerScoredName;
    }

    public void setPlayerScoredName(String playerScoredName) {
        this.playerScoredName = playerScoredName;
    }

    public String getPlayerScoredLastName() {
        return playerScoredLastName;
    }

    public void setPlayerScoredLastName(String playerScoredLastName) {
        this.playerScoredLastName = playerScoredLastName;
    }

    public String getPlayerAssistedName() {
        return playerAssistedName;
    }

    public void setPlayerAssistedName(String playerAssistedName) {
        this.playerAssistedName = playerAssistedName;
    }

    public String getPlayerAssistedLastName() {
        return playerAssistedLastName;
    }

    public void setPlayerAssistedLastName(String playerAssistedLastName) {
        this.playerAssistedLastName = playerAssistedLastName;
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
