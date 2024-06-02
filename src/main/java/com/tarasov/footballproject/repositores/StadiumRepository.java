package com.tarasov.footballproject.repositores;

import com.tarasov.footballproject.entities.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Integer> {
//    @Transactional(readOnly = true)
//    @Query("select s from Stadium s where s.stadiumName  = ?1")
//    Stadium findStadiumByStadiumNameIgnoreCase(String name);

    @Transactional(readOnly = true)
    Stadium findStadiumByStadiumNameContainingIgnoreCase(String name);

}
