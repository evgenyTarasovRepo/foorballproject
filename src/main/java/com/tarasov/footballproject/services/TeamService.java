package com.tarasov.footballproject.services;

import com.tarasov.footballproject.dto.TeamDTO;
import com.tarasov.footballproject.entities.City;
import com.tarasov.footballproject.entities.Stadium;
import com.tarasov.footballproject.entities.Team;
import com.tarasov.footballproject.repositores.CityRepository;
import com.tarasov.footballproject.repositores.StadiumRepository;
import com.tarasov.footballproject.repositores.TeamRepository;
import com.tarasov.footballproject.utils.TeamDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private TeamRepository teamRepository;
    private CityRepository cityRepository;
    private StadiumRepository stadiumRepository;
    private TeamDTOMapper teamDTOMapper;

    @Autowired
    public TeamService(TeamRepository teamRepository, CityRepository cityRepository,
                       StadiumRepository stadiumRepository, TeamDTOMapper teamDTOMapper) {
        this.teamRepository = teamRepository;
        this.cityRepository = cityRepository;
        this.stadiumRepository = stadiumRepository;
        this.teamDTOMapper = teamDTOMapper;
    }

    @Transactional
    public Team saveTeam(String cityName, String stadiumName, Team newTeam) {
        Team savedTeam = new Team();
        City city = cityRepository.findCityByCityNameIgnoreCase(cityName);
        Stadium stadium = stadiumRepository.findStadiumByStadiumNameIgnoreCase(stadiumName);

        savedTeam.setTeamName(newTeam.getTeamName());
        savedTeam.setCity(city);
        savedTeam.setStadium(stadium);

        return teamRepository.save(savedTeam);
    }

    public List<TeamDTO> findAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(teamDTOMapper)
                .collect(Collectors.toList());
    }

    public TeamDTO findTeamById(Long id) {
        return teamRepository.findById(id)
                .map(teamDTOMapper)
                .get();
    }

    @Transactional
    public void deleteTeamById(Long id) {
        Team deletedTeam = teamRepository.findById(id).get();
        deletedTeam.setStadium(null);
        deletedTeam.setCity(null);

        teamRepository.delete(deletedTeam);
    }

    @Transactional
    public Team updateTeam(Long id, Team teamForUpdate) {
        Team updatedTeam = teamRepository.findById(id).get();
        updatedTeam.setTeamName(teamForUpdate.getTeamName());

        return teamRepository.save(updatedTeam);
    }
}
