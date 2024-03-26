package com.tarasov.footballproject.controllers;

import com.tarasov.footballproject.dto.TeamDTO;
import com.tarasov.footballproject.entities.Team;
import com.tarasov.footballproject.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamController {
    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/teams")
    public ResponseEntity<Void> saveTeam(@RequestParam("city") String cityName, @RequestParam("stadium") String stadiumName,
    @RequestBody Team newTeam) {
        teamService.saveTeam(cityName, stadiumName, newTeam);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/teams")
    public ResponseEntity<List<TeamDTO>> findAllTeams() {
        List<TeamDTO> teams = teamService.findAllTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<TeamDTO> findTEamById(@PathVariable Long id) {
        TeamDTO teamDTO = teamService.findTeamById(id);
        return ResponseEntity.ok(teamDTO);
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<String> deleteTeamById(@PathVariable Long id) {
        teamService.deleteTeamById(id);

        return ResponseEntity.ok("Team with id: " + id + " was deleted");
    }

    @PutMapping("/teams/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody Team team) {
        teamService.updateTeam(id, team);

        return ResponseEntity.ok(team);
    }

}
