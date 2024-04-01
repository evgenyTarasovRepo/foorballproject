package com.tarasov.footballproject.services;

import com.tarasov.footballproject.dto.get.GetFullTeamInfoDTO;
import com.tarasov.footballproject.dto.get.GetTeamDTO;
import com.tarasov.footballproject.dto.post.PostTeamDTO;
import com.tarasov.footballproject.entities.City;
import com.tarasov.footballproject.entities.Stadium;
import com.tarasov.footballproject.entities.Team;
import com.tarasov.footballproject.exceptions.TeamNotFoundException;
import com.tarasov.footballproject.repositores.CityRepository;
import com.tarasov.footballproject.repositores.StadiumRepository;
import com.tarasov.footballproject.repositores.TeamRepository;
import com.tarasov.footballproject.utils.TeamDTOFullTeamMapper;
import com.tarasov.footballproject.utils.TeamDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private TeamRepository teamRepository;
    private CityRepository cityRepository;
    private StadiumRepository stadiumRepository;
    private TeamDTOMapper teamDTOMapper;
    private TeamDTOFullTeamMapper teamDTOFullTeamMapper;

    @Autowired
    public TeamService(TeamRepository teamRepository, CityRepository cityRepository,
                       StadiumRepository stadiumRepository, TeamDTOMapper teamDTOMapper, TeamDTOFullTeamMapper teamDTOFullTeamMapper) {
        this.teamRepository = teamRepository;
        this.cityRepository = cityRepository;
        this.stadiumRepository = stadiumRepository;
        this.teamDTOMapper = teamDTOMapper;
        this.teamDTOFullTeamMapper = teamDTOFullTeamMapper;
    }

    @Transactional
    public Team saveTeam(PostTeamDTO postTeamDTO) {
        Team savedTeam = new Team();
        City city = cityRepository.findCityByCityNameIgnoreCase(postTeamDTO.getTeamCity());
        Stadium stadium = stadiumRepository.findStadiumByStadiumNameIgnoreCase(postTeamDTO.getTeamStadium());

        savedTeam.setTeamName(postTeamDTO.getTeamName());
        savedTeam.setCity(city);
        savedTeam.setStadium(stadium);

        return teamRepository.save(savedTeam);
    }

    public List<GetTeamDTO> findAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(teamDTOMapper)
                .collect(Collectors.toList());
    }

    public GetTeamDTO findTeamById(Integer id) {
        return teamRepository.findById(id)
                .map(teamDTOMapper)
                .get();
    }

    public GetFullTeamInfoDTO getFullTeamInfo(Integer id) {
        Optional<Team> team = teamRepository.getFullTeam(id);
        GetFullTeamInfoDTO teamInfoDTO = null;
        if (team.isPresent()) {
            teamInfoDTO = team.map(teamDTOFullTeamMapper).get();
        }
        else {
            throw new TeamNotFoundException("Did not find team with id " + id);
        }

        return  teamInfoDTO;
    }

    @Transactional
    public void deleteTeamById(Integer id) {
        Team deletedTeam = teamRepository.findById(id).get();
        deletedTeam.setStadium(null);
        deletedTeam.setCity(null);

        teamRepository.delete(deletedTeam);
    }

    @Transactional
    public Team updateTeam(Integer id, Team teamForUpdate) {
        Team updatedTeam = teamRepository.findById(id).get();
        updatedTeam.setTeamName(teamForUpdate.getTeamName());

        return teamRepository.save(updatedTeam);
    }
}
