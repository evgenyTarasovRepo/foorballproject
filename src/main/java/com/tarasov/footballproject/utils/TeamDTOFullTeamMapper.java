package com.tarasov.footballproject.utils;

import com.tarasov.footballproject.dto.get.GetFullTeamInfoDTO;
import com.tarasov.footballproject.entities.Team;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TeamDTOFullTeamMapper implements Function<Team, GetFullTeamInfoDTO> {
    @Override
    public GetFullTeamInfoDTO apply(Team team) {
        GetFullTeamInfoDTO dto = new GetFullTeamInfoDTO();
        dto.setId(team.getId());
        dto.setTeam(team.getTeamName());
        if (team.getManager() != null) {
            dto.setManager(team.getManager().getFirstName() + " " + team.getManager().getLastName());
        } else {
            dto.setManager(null);
        }

        if (team.getCity() != null) {
            dto.setCity(team.getCity().getName());
        } else {
            dto.setCity(null);
        }

        if (team.getStadium() != null) {
            dto.setStadium(team.getStadium().getStadiumName());
        } else {
            dto.setStadium(null);
        }

        if (team.getPlayers() != null) {
            dto.setPlayers(team.getPlayers());
        } else {
            dto.setPlayers(null);
        }

        return dto;
    }
}
