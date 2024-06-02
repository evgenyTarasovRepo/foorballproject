package com.tarasov.footballproject.mappers;

import com.tarasov.footballproject.dto.get.GetPlayerDTO;
import com.tarasov.footballproject.entities.Player;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PlayerDTOMapper implements Function<Player, GetPlayerDTO> {
    @Override
    public GetPlayerDTO apply(Player player) {
        return new GetPlayerDTO(
                player.getId(),
                player.getFirstName(),
                player.getLastName(),
                player.getNationality(),
                player.getDob(),
                player.getPlayerNumber(),
                player.getPosition(),
                player.getTeam().getTeamName()
        );
    }
}
