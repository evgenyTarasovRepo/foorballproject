package com.tarasov.footballproject.controllers;

import com.tarasov.footballproject.entities.City;
import com.tarasov.footballproject.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CityController {

    CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/cities")
    public ResponseEntity<Void> addCity(@RequestBody City city) {
        cityService.saveCity(city);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> findCityById(@PathVariable Long id) {
        City city =  cityService.findCityById(id).get();
        return ResponseEntity.ok(city);
    }
}
