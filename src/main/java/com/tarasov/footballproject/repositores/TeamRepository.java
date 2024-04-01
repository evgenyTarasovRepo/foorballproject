package com.tarasov.footballproject.repositores;

import com.tarasov.footballproject.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query("select t from Team t where t.teamName = ?1")
    Team findTeamByTeamNameIgnoreCase(String name);

    @Query("select t from Team t " +
            "left join fetch t.manager " +
            "left join fetch t.players " +
            "left join fetch t.city " +
            "left join fetch t.stadium " +
            "where t.id = ?1")
    Optional<Team> getFullTeam(Long id);
}
