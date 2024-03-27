package com.tarasov.footballproject.utils;

import com.tarasov.footballproject.dto.get.GetManagerDTO;
import com.tarasov.footballproject.dto.post.PostManagerDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DTOManagerMapper implements Function<GetManagerDTO, PostManagerDTO> {
    @Override
    public PostManagerDTO apply(GetManagerDTO getManagerDTO) {
        return new PostManagerDTO(
                getManagerDTO.getFirstName(),
                getManagerDTO.getLastName(),
                getManagerDTO.getNationality(),
                getManagerDTO.getDob(),
                getManagerDTO.getTeamName()
        );
    }
}
