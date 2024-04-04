package com.tarasov.footballproject.services;

import com.tarasov.footballproject.dto.post.PostMatchDTO;
import com.tarasov.footballproject.entities.Match;
import com.tarasov.footballproject.entities.Team;
import com.tarasov.footballproject.repositores.CityRepository;
import com.tarasov.footballproject.repositores.MatchRepository;
import com.tarasov.footballproject.repositores.StadiumRepository;
import com.tarasov.footballproject.repositores.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MatchService {
    private MatchRepository matchRepository;
    private TeamRepository teamRepository;
    private CityRepository cityRepository;
    private StadiumRepository stadiumRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository, TeamRepository teamRepository, CityRepository cityRepository, StadiumRepository stadiumRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.cityRepository = cityRepository;
        this.stadiumRepository = stadiumRepository;
    }

    @Transactional
    public Match saveMatch(PostMatchDTO matchDTO) {
        Match newMatch = new Match();
        Team homeTeam = teamRepository.getFullTeamByName(matchDTO.getHomeTeam()).get();
        Team awayTeam = teamRepository.getFullTeamByName(matchDTO.getAwayTeam()).get();

        newMatch.setMatchDateTime(matchDTO.getMatchDateTime());
        newMatch.setHomeTeam(homeTeam);
        newMatch.setAwayTeam(awayTeam);
        newMatch.setHomeStadium(homeTeam.getStadium());
        newMatch.setHomeTeamScore(matchDTO.getHomeTeamScore());
        newMatch.setAwayTeamScore(matchDTO.getAwayTeamScore());
        newMatch.setAttendance(matchDTO.getAttendance());

        matchRepository.save(newMatch);
        return newMatch;
    }
}
