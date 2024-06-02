package com.tarasov.footballproject.mappers;

import com.tarasov.footballproject.dto.get.GetAssistantsGTO;
import com.tarasov.footballproject.entities.Player;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AssistantDTOMapper implements Function<Player, GetAssistantsGTO> {
    @Override
    public GetAssistantsGTO apply(Player player) {
        return new GetAssistantsGTO(
                player.getFirstName(),
                player.getLastName(),
                player.getPlayerNumber(),
                player.getTeam().getTeamName(),
                player.getPlayerAssists()
        );
    }
}
