package com.tarasov.footballproject.controllers;

import com.tarasov.footballproject.dto.post.PostMatchDTO;
import com.tarasov.footballproject.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MatchController {
    private MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/matches")
    public ResponseEntity<Void> saveMatch(@RequestBody PostMatchDTO matchDTO) {
        matchService.saveMatch(matchDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
