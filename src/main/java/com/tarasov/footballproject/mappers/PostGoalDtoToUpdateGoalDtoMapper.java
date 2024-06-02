package com.tarasov.footballproject.mappers;

import com.tarasov.footballproject.dto.post.PostGoalDTO;
import com.tarasov.footballproject.dto.update.UpdateGoalDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PostGoalDtoToUpdateGoalDtoMapper implements Function<PostGoalDTO, UpdateGoalDTO> {
    @Override
    public UpdateGoalDTO apply(PostGoalDTO postGoalDTO) {
        return new UpdateGoalDTO(
                postGoalDTO.getPlayerScoredName() + " " + postGoalDTO.getPlayerScoredLastName(),
                postGoalDTO.getPlayerAssistedName() + " " + postGoalDTO.getPlayerAssistedLastName(),
                postGoalDTO.getGoalMinute(),
                postGoalDTO.getMatchId()
        );
    }
}
