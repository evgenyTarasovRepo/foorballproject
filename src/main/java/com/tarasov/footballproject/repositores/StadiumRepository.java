package com.tarasov.footballproject.repositores;

import com.tarasov.footballproject.entities.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Integer> {
    @Query("select s from Stadium s where s.stadiumName = ?1")
    Stadium findStadiumByStadiumNameIgnoreCase(String name);
}
