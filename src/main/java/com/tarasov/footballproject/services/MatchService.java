package com.tarasov.footballproject.services;

import com.tarasov.footballproject.repositores.CityRepository;
import com.tarasov.footballproject.repositores.MatchRepository;
import com.tarasov.footballproject.repositores.StadiumRepository;
import com.tarasov.footballproject.repositores.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {
    private MatchRepository matchRepository;
    private TeamRepository teamRepository;
    private CityRepository cityRepository;
    private StadiumRepository stadiumRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository, TeamRepository teamRepository, CityRepository cityRepository, StadiumRepository stadiumRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.cityRepository = cityRepository;
        this.stadiumRepository = stadiumRepository;
    }
}
