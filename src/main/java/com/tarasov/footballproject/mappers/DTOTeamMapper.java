package com.tarasov.footballproject.mappers;

import com.tarasov.footballproject.dto.get.GetTeamDTO;
import com.tarasov.footballproject.dto.post.PostTeamDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DTOTeamMapper implements Function<GetTeamDTO, PostTeamDTO> {

    @Override
    public PostTeamDTO apply(GetTeamDTO getTeamDTO) {
        return new PostTeamDTO(
                getTeamDTO.getTeamName(),
                getTeamDTO.getTeamCity(),
                getTeamDTO.getTeamStadium()
        );
    }
}
