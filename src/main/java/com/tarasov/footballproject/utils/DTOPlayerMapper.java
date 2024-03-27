package com.tarasov.footballproject.utils;

import com.tarasov.footballproject.dto.get.GetPlayerDTO;
import com.tarasov.footballproject.dto.post.PostPlayerDTO;

import java.util.function.Function;

public class DTOPlayerMapper implements Function<GetPlayerDTO, PostPlayerDTO> {
    @Override
    public PostPlayerDTO apply(GetPlayerDTO getPlayerDTO) {
        return new PostPlayerDTO(
                getPlayerDTO.getFirstName(),
                getPlayerDTO.getLastName(),
                getPlayerDTO.getNationality(),
                getPlayerDTO.getDob(),
                getPlayerDTO.getPlayerNumber(),
                getPlayerDTO.getPosition(),
                getPlayerDTO.getTeamName()
        );
    }
}
