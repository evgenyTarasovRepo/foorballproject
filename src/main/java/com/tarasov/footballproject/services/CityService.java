package com.tarasov.footballproject.services;

import com.tarasov.footballproject.entities.City;
import com.tarasov.footballproject.repositores.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CityService {

    private CityRepository cityRepository;


    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    @Transactional
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    public Optional<City> findCityById(Long id) {
        return cityRepository.findById(id);
    }
}
