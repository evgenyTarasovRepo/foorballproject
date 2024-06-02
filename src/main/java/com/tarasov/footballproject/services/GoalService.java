package com.tarasov.footballproject.services;

import com.tarasov.footballproject.dto.get.GetGoalDTO;
import com.tarasov.footballproject.dto.post.PostGoalDTO;
import com.tarasov.footballproject.dto.update.UpdateGoalDTO;
import com.tarasov.footballproject.entities.Goal;
import com.tarasov.footballproject.entities.Match;
import com.tarasov.footballproject.entities.Player;
import com.tarasov.footballproject.mappers.PostGoalDtoToUpdateGoalDtoMapper;
import com.tarasov.footballproject.repositores.GoalRepository;
import com.tarasov.footballproject.repositores.MatchRepository;
import com.tarasov.footballproject.repositores.PlayerRepository;
import com.tarasov.footballproject.mappers.GoalDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalService {

    private GoalRepository goalRepository;
    private MatchRepository matchRepository;
    private PlayerRepository playerRepository;
    private GoalDTOMapper goalDTOMapper;
    private PostGoalDtoToUpdateGoalDtoMapper postGoalDtoToUpdateGoalDto;

    @Autowired
    public GoalService(GoalRepository goalRepository, MatchRepository matchRepository,
                       PlayerRepository playerRepository, GoalDTOMapper goalDTOMapper,
                       PostGoalDtoToUpdateGoalDtoMapper postGoalDtoToUpdateGoalDto) {
        this.goalRepository = goalRepository;
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
        this.goalDTOMapper = goalDTOMapper;
        this.postGoalDtoToUpdateGoalDto = postGoalDtoToUpdateGoalDto;
    }

    @Transactional
    public Goal saveGoal(PostGoalDTO postGoalDTO) {
        Player scoredPlayer = playerRepository.findPlayerByFirstNameAndLastName(postGoalDTO.getPlayerScoredName(), postGoalDTO.getPlayerScoredLastName());
        Player assistPlayer = playerRepository.findPlayerByFirstNameAndLastName(postGoalDTO.getPlayerAssistedName(), postGoalDTO.getPlayerAssistedLastName());
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

    @Transactional
    public UpdateGoalDTO updateMatch(Integer id, PostGoalDTO postGoalDTO) {
        Goal updatedGoal = goalRepository.findById(id).get();
        Player updatedScoredPlayer = playerRepository.findPlayerByFirstNameAndLastName(postGoalDTO.getPlayerScoredName(), postGoalDTO.getPlayerScoredLastName());
        Player updatedAssistedPlayer = playerRepository.findPlayerByFirstNameAndLastName(postGoalDTO.getPlayerAssistedName(), postGoalDTO.getPlayerAssistedLastName());
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

        goalRepository.save(updatedGoal);
        return postGoalDtoToUpdateGoalDto.apply(postGoalDTO);
    }
}
