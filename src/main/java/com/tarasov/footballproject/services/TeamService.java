package com.tarasov.footballproject.services;

import com.tarasov.footballproject.entities.City;
import com.tarasov.footballproject.entities.Stadium;
import com.tarasov.footballproject.entities.Team;
import com.tarasov.footballproject.repositores.CityRepository;
import com.tarasov.footballproject.repositores.StadiumRepository;
import com.tarasov.footballproject.repositores.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {
    private TeamRepository teamRepository;
    private CityRepository cityRepository;
    private StadiumRepository stadiumRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, CityRepository cityRepository, StadiumRepository stadiumRepository) {
        this.teamRepository = teamRepository;
        this.cityRepository = cityRepository;
        this.stadiumRepository = stadiumRepository;
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

    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }

    public Team findTeamById(Long id) {
        return teamRepository.findById(id).get();
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
