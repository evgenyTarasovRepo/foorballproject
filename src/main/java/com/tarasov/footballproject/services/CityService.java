package com.tarasov.footballproject.services;

import com.tarasov.footballproject.dto.get.GetCityDTO;
import com.tarasov.footballproject.entities.City;
import com.tarasov.footballproject.entities.Stadium;
import com.tarasov.footballproject.repositores.CityRepository;
import com.tarasov.footballproject.utils.CityToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService {

    private CityRepository cityRepository;
    private CityToDtoMapper cityToDtoMapper;


    @Autowired
    public CityService(CityRepository cityRepository, CityToDtoMapper cityToDtoMapper) {
        this.cityRepository = cityRepository;
        this.cityToDtoMapper = cityToDtoMapper;
    }


    @Transactional
    public City saveCity(City newCity) {
        City savedCity = new City(newCity.getName(), newCity.getCountryName());
        List<Stadium> stadiums = newCity.getStadiums();

        for (Stadium s : stadiums) {
            savedCity.addStadium(s);
        }
        return cityRepository.save(savedCity);
    }

    public GetCityDTO findCityById(Integer id) {

        return cityRepository.findById(id)
                .map(cityToDtoMapper)
                .get();
    }

    public List<GetCityDTO> findAllCities() {

        return cityRepository.findAll().stream().map(cityToDtoMapper).collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(Integer id) {
        City cityForDelete = cityRepository.findById(id).get();
        cityRepository.delete(cityForDelete);
    }

    @Transactional
    public City updateCity(Integer id, City cityDataForUpdate) {
        City existingCity = cityRepository.findById(id).get();
        existingCity.setName(cityDataForUpdate.getName());
        existingCity.setCountryName(cityDataForUpdate.getCountryName());

        return cityRepository.save(existingCity);
    }
}
