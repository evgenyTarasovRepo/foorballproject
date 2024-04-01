package com.tarasov.footballproject.controllers;

import com.tarasov.footballproject.entities.Stadium;
import com.tarasov.footballproject.services.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StadiumController {

    StadiumService stadiumService;

    @Autowired
    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @PostMapping("/stadiums")
    public ResponseEntity<Void> addStadium(@RequestBody Stadium stadium) {
        stadiumService.saveStadium(stadium);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/stadiums/{id}")
    public ResponseEntity<Stadium> findStadiumById(@PathVariable Integer id) {
        Stadium stadium = stadiumService.findStadiumById(id).get();

        return ResponseEntity.ok(stadium);
    }

    @GetMapping("/stadiums")
    public ResponseEntity<List<Stadium>> findAllCities() {
        List<Stadium> stadiums = stadiumService.findAllStadiums();
        return ResponseEntity.ok(stadiums);
    }

    @PutMapping("/stadiums/{id}")
    public ResponseEntity<Stadium> updateStadium(@PathVariable Integer id, @RequestBody Stadium stadiumDataForUpdate) {

        stadiumService.updateStadium(id, stadiumDataForUpdate);
        return ResponseEntity.ok(stadiumDataForUpdate);
    }

    @DeleteMapping("/stadiums/{id}")
    public ResponseEntity<String> deleteStadium(@PathVariable Integer id) {
        stadiumService.deleteStadium(id);

        return ResponseEntity.ok("Stadium " + id + " was deleted@");
    }
}
