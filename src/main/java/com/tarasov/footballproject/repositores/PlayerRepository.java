package com.tarasov.footballproject.repositores;

import com.tarasov.footballproject.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query("select p from Player p where p.team.teamName = ?1 order by p.playerNumber")
    @Transactional(readOnly = true)
    List<Player> findPlayersByTeamNameIgnoreCase(String team);

    @Transactional(readOnly = true)
    Player findPlayerByFirstNameAndLastName(String firstName, String lastName);
}
