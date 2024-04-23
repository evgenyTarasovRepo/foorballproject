package com.tarasov.footballproject.controllers;

import com.tarasov.footballproject.dto.get.GetPlayerDTO;
import com.tarasov.footballproject.dto.get.GetScorersGTO;
import com.tarasov.footballproject.dto.post.PostPlayerDTO;
import com.tarasov.footballproject.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/players")
    public ResponseEntity<Void> savePlayer(@RequestBody PostPlayerDTO postPlayerDTO) {
        playerService.savePlayer(postPlayerDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/players")
    public ResponseEntity<List<GetPlayerDTO>> findAllPlayers() {
        List<GetPlayerDTO> players = playerService.findAllPlayers();

        return ResponseEntity.ok(players);
    }

    @GetMapping("/players/scorers")
    public ResponseEntity<List<GetScorersGTO>> findAllScorers() {
        List<GetScorersGTO> scorers = playerService.findAllScorers();

        return ResponseEntity.ok(scorers);
    }
    @GetMapping("/players/team/{team}")
    public ResponseEntity<List<GetPlayerDTO>> findPlayersByTeamName(@PathVariable String team) {
        URLDecoder.decode(team, StandardCharsets.UTF_8);
        List<GetPlayerDTO> players = playerService.findPlayersByTeamName(team);

        return ResponseEntity.ok(players);
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<GetPlayerDTO> findPlayerById(@PathVariable Integer id) {
        GetPlayerDTO playerDTO = playerService.findPlayerById(id);
        return ResponseEntity.ok(playerDTO);
    }

    @DeleteMapping("players/{id}")
    public ResponseEntity<String> deletePlayerById(@PathVariable Integer id) {
        playerService.deletePlayerById(id);
        return ResponseEntity.ok("Player with id: " + id + " was deleted");
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<PostPlayerDTO> updatePlayer(@PathVariable Integer id, @RequestBody PostPlayerDTO postPlayerDTO) {
        playerService.updatePlayer(id, postPlayerDTO);
        return ResponseEntity.ok(postPlayerDTO);
    }
}
