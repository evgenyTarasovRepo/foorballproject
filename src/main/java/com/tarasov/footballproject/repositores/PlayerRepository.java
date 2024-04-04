package com.tarasov.footballproject.repositores;

import com.tarasov.footballproject.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query("select p from Player p where p.team.teamName = ?1 order by p.playerNumber")
    List<Player> findPlayersByTeamNameIgnoreCase(String team);
}
