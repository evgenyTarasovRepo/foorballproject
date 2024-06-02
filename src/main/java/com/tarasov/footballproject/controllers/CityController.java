package com.tarasov.footballproject.controllers;

import com.tarasov.footballproject.dto.get.GetCityDTO;
import com.tarasov.footballproject.entities.City;
import com.tarasov.footballproject.entities.Stadium;
import com.tarasov.footballproject.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/cities")
    public ResponseEntity<Void> addCity(@RequestBody City newCity) {
        cityService.saveCity(newCity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/cities")
    public ResponseEntity<List<GetCityDTO>> findAllCities() {
        List<GetCityDTO> cities = cityService.findAllCities();

        return ResponseEntity.ok(cities);
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<GetCityDTO> findCityById(@PathVariable Integer id) {
        GetCityDTO city = cityService.findCityById(id);
        return ResponseEntity.ok(city);
    }

    @PutMapping("/cities/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Integer id, @RequestBody City cityDataForUpdate) {
        cityService.updateCity(id, cityDataForUpdate);
        return ResponseEntity.ok(cityDataForUpdate);
    }

    @DeleteMapping("cities/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable Integer id) {
        cityService.deleteById(id);

        return ResponseEntity.ok("City with id: " + id + " deleted");
    }
}
