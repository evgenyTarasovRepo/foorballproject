package com.tarasov.footballproject.utils;

import com.tarasov.footballproject.dto.post.PostManagerDTO;
import com.tarasov.footballproject.entities.Manager;

import java.util.function.Function;

public class ManagerDTOMapper implements Function<Manager, PostManagerDTO> {
    @Override
    public PostManagerDTO apply(Manager manager) {
        return new PostManagerDTO(
                manager.getFirstName(),
                manager.getLastName(),
                manager.getNationality(),
                manager.getDob(),
                manager.getTeam().getTeamName()
        );
    }
}
