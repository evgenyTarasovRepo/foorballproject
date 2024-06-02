package com.tarasov.footballproject.mappers;

import com.tarasov.footballproject.dto.get.GetMatchDTO;
import com.tarasov.footballproject.entities.Match;
import com.tarasov.footballproject.entities.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MatchDTOMapper implements Function<Match, GetMatchDTO> {

    @Override
    public GetMatchDTO apply(Match match) {
        return new GetMatchDTO(
                match.getId(),
                match.getMatchDateTime(),
                match.getHomeTeam().getTeamName(),
                getPlayersNames(match.getHomeTeam().getPlayers()),
                match.getAwayTeam().getTeamName(),
                getPlayersNames(match.getAwayTeam().getPlayers()),
                match.getHomeStadium().getStadiumName(),
                match.getAttendance()
        );
    }

    private List<String> getPlayersNames(List<Player> playerList) {

        return playerList.stream().map(
                player -> player.getFirstName() + " " + player.getLastName()
        ).collect(Collectors.toList());
    }

}
