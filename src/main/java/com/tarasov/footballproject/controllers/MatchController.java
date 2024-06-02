package com.tarasov.footballproject.controllers;

import com.tarasov.footballproject.dto.get.GetMatchDTO;
import com.tarasov.footballproject.dto.post.PostMatchDTO;
import com.tarasov.footballproject.entities.Match;
import com.tarasov.footballproject.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/matches/{id}")
    public ResponseEntity<GetMatchDTO> findMatchById(@PathVariable Integer id) {
        GetMatchDTO getMatchDTO = matchService.findMatchById(id);

        return ResponseEntity.ok(getMatchDTO);
    }

    @GetMapping("/matches")
    public ResponseEntity<List<GetMatchDTO>> findAllMatches() {
        List<GetMatchDTO> matchList = matchService.findAllMatches();
        return ResponseEntity.ok(matchList);
    }

    @PutMapping("/matches/{id}/endMatch")
    public ResponseEntity<String> updateMatchStatus(@PathVariable Integer id){
        matchService.updateMatchStatus(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/matches/{id}")
    public ResponseEntity<String> deleteMatchById(@PathVariable Integer id) {
        matchService.deleteMatchById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("matches/{id}")
    public ResponseEntity<PostMatchDTO> updateMatch(@PathVariable Integer id, @RequestBody PostMatchDTO postMatchDTO) {
        PostMatchDTO updatedMatch = matchService.updateMatch(id, postMatchDTO);
        return ResponseEntity.ok(updatedMatch);
    }
}
