package com.tarasov.footballproject.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Integer id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "p_id")
    private Player scoredPlayer;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "a_id")
    private Player assistedPlayer;

    @Column(name = "goal_minute")
    private Integer goalMinute;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "match_id")
    private Match match;

    public Goal() {
    }

    public Goal(Player scoredPlayer, Player assistedPlayer, Integer goalMinute, Match match) {
        this.scoredPlayer = scoredPlayer;
        this.assistedPlayer = assistedPlayer;
        this.goalMinute = goalMinute;
        this.match = match;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getScoredPlayer() {
        return scoredPlayer;
    }

    public void setScoredPlayer(Player scoredPlayer) {
        this.scoredPlayer = scoredPlayer;
    }

    public Player getAssistedPlayer() {
        return assistedPlayer;
    }

    public void setAssistedPlayer(Player assistedPlayer) {
        this.assistedPlayer = assistedPlayer;
    }

    public Integer getGoalMinute() {
        return goalMinute;
    }

    public void setGoalMinute(Integer goalMinute) {
        this.goalMinute = goalMinute;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

}
