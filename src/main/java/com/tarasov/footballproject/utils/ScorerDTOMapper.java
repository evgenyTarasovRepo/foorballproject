package com.tarasov.footballproject.utils;

import com.tarasov.footballproject.dto.get.GetScorersGTO;
import com.tarasov.footballproject.entities.Player;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ScorerDTOMapper implements Function<Player, GetScorersGTO> {
    @Override
    public GetScorersGTO apply(Player player) {
        return new GetScorersGTO(
                player.getFirstName(),
                player.getLastName(),
                player.getPlayerNumber(),
                player.getPosition(),
                player.getTeam().getTeamName(),
                player.getPlayerGoals()
        );
    }
}
