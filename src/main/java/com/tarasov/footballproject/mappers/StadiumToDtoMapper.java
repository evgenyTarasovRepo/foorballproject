package com.tarasov.footballproject.mappers;

import com.tarasov.footballproject.dto.get.GetStadiumDTO;
import com.tarasov.footballproject.entities.Stadium;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class StadiumToDtoMapper implements Function<Stadium, GetStadiumDTO> {
    @Override
    public GetStadiumDTO apply(Stadium stadium) {
        return new GetStadiumDTO(
                stadium.getId(),
                stadium.getStadiumName(),
                stadium.getCapacity(),
                stadium.getCity().getName()
        );
    }
}
