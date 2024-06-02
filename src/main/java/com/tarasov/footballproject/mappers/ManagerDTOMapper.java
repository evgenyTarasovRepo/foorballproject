package com.tarasov.footballproject.mappers;

import com.tarasov.footballproject.dto.get.GetManagerDTO;
import com.tarasov.footballproject.entities.Manager;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ManagerDTOMapper implements Function<Manager, GetManagerDTO> {
    @Override
    public GetManagerDTO apply(Manager manager) {
        return new GetManagerDTO(
                manager.getId(),
                manager.getFirstName(),
                manager.getLastName(),
                manager.getNationality(),
                manager.getDob(),
                manager.getTeam().getTeamName()
        );
    }
}
