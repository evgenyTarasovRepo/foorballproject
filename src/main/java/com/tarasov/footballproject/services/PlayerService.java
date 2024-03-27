package com.tarasov.footballproject.services;

import com.tarasov.footballproject.dto.get.GetPlayerDTO;
import com.tarasov.footballproject.dto.post.PostPlayerDTO;
import com.tarasov.footballproject.entities.Player;
import com.tarasov.footballproject.entities.Team;
import com.tarasov.footballproject.repositores.PlayerRepository;
import com.tarasov.footballproject.repositores.TeamRepository;
import com.tarasov.footballproject.utils.PlayerDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;
    private PlayerDTOMapper playerDTOMapper;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository, PlayerDTOMapper playerDTOMapper) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.playerDTOMapper = playerDTOMapper;
    }

    public Player savePlayer(PostPlayerDTO postPlayerDTO) {
        Player player = constructPlayer(postPlayerDTO);
        Team team = getTeamByName(postPlayerDTO.getTeamName());

        player.setTeam(team);
        team.addPlayer(player);

        return playerRepository.save(player);
    }

    public List<GetPlayerDTO> findAllPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(playerDTOMapper)
                .collect(Collectors.toList());
    }

    public GetPlayerDTO findPlayerById(Long id) {
        return playerRepository.findById(id)
                .map(playerDTOMapper)
                .get();
    }

    @Transactional
    public void deletePlayerById(Long id) {
        Player deletedPlayer = playerRepository.findById(id).get();
        deletedPlayer.setTeam(null);
        playerRepository.deleteById(id);
    }

    @Transactional
    public Player updatePlayer(Long id, PostPlayerDTO playerForUpdate) {
        Player updatedPlayer = playerRepository.findById(id).get();
        Team teamForUpdate = getTeamByName(playerForUpdate.getTeamName());
        updatedPlayer = constructPlayer(playerForUpdate);
        updatedPlayer.setId(id.intValue());

        updatedPlayer.setTeam(teamForUpdate);
        teamForUpdate.addPlayer(updatedPlayer);

        return playerRepository.save(updatedPlayer);
    }

    private Team getTeamByName(String teamName) {
        return teamRepository.findTeamByTeamNameIgnoreCase(teamName);
    }

    private Player constructPlayer(PostPlayerDTO postPlayerDTO) {
        Player player = new Player();

        player.setFirstName(postPlayerDTO.getFirstName());
        player.setLastName(postPlayerDTO.getLastName());
        player.setNationality(postPlayerDTO.getNationality());
        player.setDob(postPlayerDTO.getDob());
        player.setPlayerNumber(postPlayerDTO.getPlayerNumber());
        player.setPosition(postPlayerDTO.getPosition());

        return player;
    }
}
