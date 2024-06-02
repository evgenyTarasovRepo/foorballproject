package com.tarasov.footballproject.services;

import com.tarasov.footballproject.dto.get.GetManagerDTO;
import com.tarasov.footballproject.dto.post.PostManagerDTO;
import com.tarasov.footballproject.entities.Manager;
import com.tarasov.footballproject.entities.Team;
import com.tarasov.footballproject.repositores.ManagerRepository;
import com.tarasov.footballproject.repositores.TeamRepository;
import com.tarasov.footballproject.mappers.ManagerDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerService {

    private ManagerRepository managerRepository;
    private TeamRepository teamRepository;
    private ManagerDTOMapper managerDTOMapper;


    @Autowired
    public ManagerService(ManagerRepository managerRepository, TeamRepository teamRepository, ManagerDTOMapper managerDTOMapper) {
        this.managerRepository = managerRepository;
        this.teamRepository = teamRepository;
        this.managerDTOMapper = managerDTOMapper;
    }

    public Manager saveManager(PostManagerDTO postManagerDTO) {
        Manager savedManager = new Manager(postManagerDTO.getFirstName(), postManagerDTO.getLastName(),
                postManagerDTO.getNationality(), postManagerDTO.getDob());
        Team team = teamRepository.findTeamByTeamNameContainingIgnoreCase(postManagerDTO.getTeamName()).get();

        savedManager.setTeam(team);
        team.setManager(savedManager);

        return managerRepository.save(savedManager);
    }

    public List<GetManagerDTO> findAllManagers() {
        return managerRepository.findAll()
                .stream()
                .map(managerDTOMapper)
                .collect(Collectors.toList());
    }

    public GetManagerDTO findManagerById(Integer id) {
        return managerRepository.findById(id)
                .map(managerDTOMapper)
                .get();
    }

    public void deleteManager(Integer id) {
        Manager manager = managerRepository.findById(id).get();
        manager.setTeam(null);

        managerRepository.delete(manager);
    }

    public Manager updateManager(Integer id, PostManagerDTO postManagerDTO) {
        Manager managerForUpdate = managerRepository.findById(id).get();
        Team teamForUpdate = teamRepository.findTeamByTeamNameContainingIgnoreCase(postManagerDTO.getTeamName()).get();

        managerForUpdate.setId(managerForUpdate.getId());
        managerForUpdate.setFirstName(postManagerDTO.getFirstName());
        managerForUpdate.setLastName(postManagerDTO.getFirstName());
        managerForUpdate.setNationality(postManagerDTO.getNationality());
        managerForUpdate.setDob(postManagerDTO.getDob());
        managerForUpdate.setTeam(teamForUpdate);

        return managerRepository.save(managerForUpdate);
    }
}
