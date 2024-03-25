package com.tarasov.footballproject.services;

import com.tarasov.footballproject.entities.City;
import com.tarasov.footballproject.entities.Stadium;
import com.tarasov.footballproject.repositores.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StadiumService {

    private StadiumRepository stadiumRepository;

    @Autowired
    public StadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    @Transactional
    public Stadium saveStadium(Stadium stadium) {

        return stadiumRepository.save(stadium);
    }

    public Optional<Stadium> findStadiumById(Long id) {
        return stadiumRepository.findById(id);
    }

    public List<Stadium> findAllStadiums() {
        return stadiumRepository.findAll();
    }

    @Transactional
    public void deleteStadium(Long id) {
        Optional<Stadium> temp = stadiumRepository.findById(id);
        Stadium deletedStadium = temp.get();
        deletedStadium.setCity(null);
        stadiumRepository.delete(deletedStadium);
    }

    @Transactional
    public Stadium updateStadium(Long id, Stadium stadiumForUpdate) {
        Stadium existingStadium = stadiumRepository.findById(id).get();
        City updatedCity = new City();

        existingStadium.setStadiumName(stadiumForUpdate.getStadiumName());
        existingStadium.setCapacity(stadiumForUpdate.getCapacity());

        updatedCity.setId(stadiumForUpdate.getCity().getId());
        updatedCity.setCityName(stadiumForUpdate.getCity().getCityName());
        updatedCity.setCountryName(stadiumForUpdate.getCity().getCountryName());

        existingStadium.setCity(updatedCity);
        return stadiumRepository.save(existingStadium);
    }
}
