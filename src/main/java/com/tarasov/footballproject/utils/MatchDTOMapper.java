package com.tarasov.footballproject.utils;

import com.tarasov.footballproject.dto.post.PostMatchDTO;
import com.tarasov.footballproject.entities.Match;
import com.tarasov.footballproject.entities.Team;
import org.springframework.stereotype.Service;

@Service
public class MatchDTOMapper  {


    public PostMatchDTO mapMatchToDTO(Team homeTeam, Team awayTeam, Match match) {
        return new PostMatchDTO(
                match.getMatchDateTime(),
                homeTeam.getTeamName(),
                awayTeam.getTeamName(),
                homeTeam.getStadium().getStadiumName(),
                match.getHomeTeamScore(),
                match.getAwayTeamScore(),
                match.getAttendance()
        );
    }

}
