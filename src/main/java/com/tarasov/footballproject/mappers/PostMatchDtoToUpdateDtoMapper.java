package com.tarasov.footballproject.mappers;

import com.tarasov.footballproject.dto.post.PostMatchDTO;
import com.tarasov.footballproject.dto.update.UpdateMatchDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PostMatchDtoToUpdateDtoMapper implements Function<PostMatchDTO, UpdateMatchDTO> {
    @Override
    public UpdateMatchDTO apply(PostMatchDTO postMatchDTO) {
        return new UpdateMatchDTO(
                postMatchDTO.getMatchDateTime(),
                postMatchDTO.getHomeTeam(),
                postMatchDTO.getAwayTeam(),
                postMatchDTO.getStadium(),
                postMatchDTO.getAttendance()
        );
    }
}
