package com.tarasov.footballproject.services;

import com.tarasov.footballproject.entities.City;
import com.tarasov.footballproject.entities.Stadium;
import com.tarasov.footballproject.repositores.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private CityRepository cityRepository;


    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    @Transactional
    public City saveCity(City newCity) {
        City savedCity = new City(newCity.getCityName(), newCity.getCountryName());
        List<Stadium> stadiums = newCity.getStadiums();

        for (Stadium s : stadiums) {
            savedCity.addStadium(s);
        }
        return cityRepository.save(savedCity);
    }

    public Optional<City> findCityById(Integer id) {
        return cityRepository.findById(id);
    }

    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    @Transactional
    public void deleteById(Integer id) {
        Optional<City> temp = cityRepository.findById(id);
        City city = temp.get();
        city.getStadiums().forEach(stadium -> stadium.setCity(null));

        cityRepository.delete(city);
    }

    @Transactional
    public City updateCity(Integer id, City cityDataForUpdate) {
        City existingCity = cityRepository.findById(id).get();
        existingCity.setCityName(cityDataForUpdate.getCityName());
        existingCity.setCountryName(cityDataForUpdate.getCountryName());

        return cityRepository.save(existingCity);
    }
}
