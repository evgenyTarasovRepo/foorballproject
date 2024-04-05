package com.tarasov.footballproject.services;

import com.tarasov.footballproject.dto.get.GetMatchDTO;
import com.tarasov.footballproject.dto.post.PostMatchDTO;
import com.tarasov.footballproject.entities.Match;
import com.tarasov.footballproject.entities.Stadium;
import com.tarasov.footballproject.entities.Team;
import com.tarasov.footballproject.repositores.CityRepository;
import com.tarasov.footballproject.repositores.MatchRepository;
import com.tarasov.footballproject.repositores.StadiumRepository;
import com.tarasov.footballproject.repositores.TeamRepository;
import com.tarasov.footballproject.utils.MatchDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MatchService {
    private MatchRepository matchRepository;
    private TeamRepository teamRepository;
    private CityRepository cityRepository;
    private StadiumRepository stadiumRepository;
    private MatchDTOMapper matchDTOMapper;

    @Autowired
    public MatchService(MatchRepository matchRepository, TeamRepository teamRepository,
                        CityRepository cityRepository, StadiumRepository stadiumRepository,
                        MatchDTOMapper matchDTOMapper) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.cityRepository = cityRepository;
        this.stadiumRepository = stadiumRepository;
        this.matchDTOMapper = matchDTOMapper;
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

    public GetMatchDTO findMatchById(Integer id){
        return matchRepository.findById(id)
                .map(matchDTOMapper)
                .get();
    }

    public List<GetMatchDTO> findAllMatches() {
        return matchRepository.findAll().stream().map(matchDTOMapper).collect(Collectors.toList());
    }

    @Transactional
    public void deleteMatchById(Integer id) {
        Match deletedMatch = matchRepository.findById(id).get();
        deletedMatch.setHomeTeam(null);
        deletedMatch.setAwayTeam(null);
        deletedMatch.setHomeStadium(null);

        matchRepository.delete(deletedMatch);
    }

    @Transactional
    public PostMatchDTO updateMatch(Integer id, PostMatchDTO postMatchDTO) {
        Match updatedMatch = matchRepository.findById(id).get();
        Team ht = teamRepository.findTeamByTeamNameIgnoreCase(postMatchDTO.getHomeTeam()).get();
        Team at = teamRepository.findTeamByTeamNameIgnoreCase(postMatchDTO.getAwayTeam()).get();
        Stadium hs = ht.getStadium();

        updatedMatch.setId(id);
        updatedMatch.setMatchDateTime(postMatchDTO.getMatchDateTime());
        updatedMatch.setHomeTeam(ht);
        updatedMatch.setAwayTeam(at);
        updatedMatch.setHomeStadium(hs);
        updatedMatch.setHomeTeamScore(postMatchDTO.getHomeTeamScore());
        updatedMatch.setAwayTeamScore(postMatchDTO.getAwayTeamScore());
        updatedMatch.setAttendance(postMatchDTO.getAttendance());

        matchRepository.save(updatedMatch);

        return postMatchDTO;
    }
}
