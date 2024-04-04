package com.tarasov.footballproject.services;

import com.tarasov.footballproject.entities.City;
import com.tarasov.footballproject.entities.Stadium;
import com.tarasov.footballproject.entities.Team;
import com.tarasov.footballproject.repositores.StadiumRepository;
import com.tarasov.footballproject.repositores.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StadiumService {

    private StadiumRepository stadiumRepository;
    private TeamRepository teamRepository;

    @Autowired
    public StadiumService(StadiumRepository stadiumRepository, TeamRepository teamRepository) {
        this.stadiumRepository = stadiumRepository;
        this.teamRepository = teamRepository;
    }

    @Transactional
    public Stadium saveStadium(Stadium stadium) {

        return stadiumRepository.save(stadium);
    }

    public Optional<Stadium> findStadiumById(Integer id) {
        return stadiumRepository.findById(id);
    }

    public List<Stadium> findAllStadiums() {
        return stadiumRepository.findAll();
    }

    @Transactional
    public void deleteStadium(Integer id) {
        Optional<Stadium> temp = stadiumRepository.findById(id);
        Stadium deletedStadium = temp.get();
        deletedStadium.setCity(null);

        Team team = teamRepository.findTeamByStadiumId(deletedStadium.getId()).get();
        team.setStadium(null);

        stadiumRepository.delete(deletedStadium);
    }

    @Transactional
    public Stadium updateStadium(Integer id, Stadium stadiumForUpdate) {
        Stadium existingStadium = stadiumRepository.findById(id).get();
        City updatedCity = new City();

        existingStadium.setId(id);
        existingStadium.setStadiumName(stadiumForUpdate.getStadiumName());
        existingStadium.setCapacity(stadiumForUpdate.getCapacity());

        updatedCity.setId(stadiumForUpdate.getCity().getId());
        updatedCity.setCityName(stadiumForUpdate.getCity().getCityName());
        updatedCity.setCountryName(stadiumForUpdate.getCity().getCountryName());

        existingStadium.setCity(updatedCity);
        return stadiumRepository.save(existingStadium);
    }
}
