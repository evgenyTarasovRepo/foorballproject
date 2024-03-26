package com.tarasov.footballproject.utils;

import com.tarasov.footballproject.dto.TeamDTO;
import com.tarasov.footballproject.entities.Team;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TeamDTOMapper implements Function<Team, TeamDTO> {

    @Override
    public TeamDTO apply(Team team) {
        return new TeamDTO(
                team.getId(),
                team.getTeamName(),
                team.getCity().getCityName(),
                team.getStadium().getStadiumName());
    }
}
