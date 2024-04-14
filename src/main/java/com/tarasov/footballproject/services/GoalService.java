package com.tarasov.footballproject.services;

import com.tarasov.footballproject.dto.get.GetGoalDTO;
import com.tarasov.footballproject.dto.post.PostGoalDTO;
import com.tarasov.footballproject.entities.Goal;
import com.tarasov.footballproject.entities.Match;
import com.tarasov.footballproject.entities.Player;
import com.tarasov.footballproject.repositores.GoalRepository;
import com.tarasov.footballproject.repositores.MatchRepository;
import com.tarasov.footballproject.repositores.PlayerRepository;
import com.tarasov.footballproject.utils.GoalDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalService {

    private GoalRepository goalRepository;
    private MatchRepository matchRepository;
    private PlayerRepository playerRepository;
    private GoalDTOMapper goalDTOMapper;

    @Autowired
    public GoalService(GoalRepository goalRepository, MatchRepository matchRepository,
                       PlayerRepository playerRepository, GoalDTOMapper goalDTOMapper) {
        this.goalRepository = goalRepository;
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
        this.goalDTOMapper = goalDTOMapper;
    }

    public Goal saveGoal(PostGoalDTO postGoalDTO) {
        Player scoredPlayer = playerRepository.findPlayerByFirstNameAndAndLastName(postGoalDTO.getPlayerScoredName(), postGoalDTO.getPlayerScoredLastName());
        Player assistPlayer = playerRepository.findPlayerByFirstNameAndAndLastName(postGoalDTO.getPlayerAssistedName(), postGoalDTO.getPlayerAssistedLastName());
        Match match = matchRepository.findById(postGoalDTO.getMatchId()).get();

        Goal savedGoal = new Goal(scoredPlayer, assistPlayer, postGoalDTO.getGoalMinute(), match);

        return goalRepository.save(savedGoal);
    }

    public GetGoalDTO findGoalById(Integer id) {
        return goalRepository.findById(id)
                .map(goalDTOMapper)
                .get();
    }

    public List<GetGoalDTO> findAllGoals() {
        return goalRepository
                .findAll()
                .stream()
                .map(goalDTOMapper)
                .collect(Collectors.toList());
    }

    public void deleteGoalById(Integer id) {
        Goal deletedGoal = goalRepository.findById(id).get();
        deletedGoal.setScoredPlayer(null);
        deletedGoal.setAssistedPlayer(null);
        deletedGoal.setMatch(null);

        goalRepository.delete(deletedGoal);
    }

    public Goal updateMatch(Integer id, PostGoalDTO postGoalDTO) {
        Goal updatedGoal = goalRepository.findById(id).get();
        Player updatedScoredPlayer = playerRepository.findPlayerByFirstNameAndAndLastName(postGoalDTO.getPlayerScoredName(), postGoalDTO.getPlayerScoredLastName());
        Player updatedAssistedPlayer = playerRepository.findPlayerByFirstNameAndAndLastName(postGoalDTO.getPlayerAssistedName(), postGoalDTO.getPlayerAssistedLastName());
        Match updatedMatch = updatedGoal.getMatch();
        updatedScoredPlayer.setFirstName(postGoalDTO.getPlayerScoredName());
        updatedScoredPlayer.setLastName(postGoalDTO.getPlayerScoredLastName());
        updatedAssistedPlayer.setFirstName(postGoalDTO.getPlayerAssistedName());
        updatedAssistedPlayer.setLastName(postGoalDTO.getPlayerScoredLastName());
        updatedMatch.setId(postGoalDTO.getMatchId());

        updatedGoal.setId(id);
        updatedGoal.setScoredPlayer(updatedScoredPlayer);
        updatedGoal.setAssistedPlayer(updatedAssistedPlayer);
        updatedGoal.setGoalMinute(postGoalDTO.getGoalMinute());
        updatedGoal.setMatch(updatedMatch);

        return goalRepository.save(updatedGoal);
    }
}
