package com.tarasov.footballproject.utils;

import com.tarasov.footballproject.dto.get.GetTeamDTO;
import com.tarasov.footballproject.entities.Team;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TeamDTOMapper implements Function<Team, GetTeamDTO> {

    @Override
    public GetTeamDTO apply(Team team) {
        return new GetTeamDTO(
                team.getId(),
                team.getTeamName(),
                team.getCity().getCityName(),
                team.getStadium().getStadiumName());
    }
}
