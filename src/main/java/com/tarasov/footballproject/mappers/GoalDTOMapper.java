package com.tarasov.footballproject.mappers;

import com.tarasov.footballproject.dto.get.GetGoalDTO;
import com.tarasov.footballproject.entities.Goal;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class GoalDTOMapper implements Function<Goal, GetGoalDTO> {
    @Override
    public GetGoalDTO apply(Goal goal) {
        return new GetGoalDTO(
                goal.getId(),
                goal.getScoredPlayer().getFirstName() + " " + goal.getScoredPlayer().getLastName(),
                goal.getAssistedPlayer().getFirstName() + " " + goal.getAssistedPlayer().getLastName(),
                goal.getGoalMinute(),
                goal.getMatch().getHomeTeam().getTeamName() + " : " + goal.getMatch().getAwayTeam().getTeamName()
        );
    }
}
