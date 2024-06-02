package com.tarasov.footballproject.mappers;

import com.tarasov.footballproject.dto.get.GetCityDTO;
import com.tarasov.footballproject.entities.City;
import com.tarasov.footballproject.entities.Stadium;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CityToDtoMapper implements Function<City, GetCityDTO> {
    @Override
    public GetCityDTO apply(City city) {
        return new GetCityDTO(
                city.getId(),
                city.getName(),
                city.getStadiums().stream().map(Stadium::getStadiumName).collect(Collectors.toList()),
                city.getStadiums().stream().map(Stadium::getCapacity).collect(Collectors.toList())
        );
    }
}
