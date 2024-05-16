package com.tarasov.footballproject.services;

import com.tarasov.footballproject.dto.testdto.BettingDto;
import com.tarasov.footballproject.entities.Match;
import com.tarasov.footballproject.exceptions.NegativeBetException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BettingServiceTest {

    @Autowired
    private BettingService bettingService;


    @Test
    @DisplayName("shouldReturnHomeTeamWinnersBet")
    void shouldReturnHomeTeamWinnersBet() {
        BettingDto winBet = new BettingDto(new BigDecimal(100), new BigDecimal(0), new BigDecimal(0),
                new BigDecimal(1.20), new BigDecimal(1.70), new BigDecimal(2.0));
        Match winMatch = new Match(null, null, null, null, null);
        winMatch.setCompleted(true);
        winMatch.setHomeTeamScore(3);
        winMatch.setAwayTeamScore(1);

        BigDecimal result = bettingService.calculateBet(winBet, winMatch);

        Assertions.assertEquals(120, result.setScale(0, RoundingMode.CEILING).intValue());
    }

    @Test
    @DisplayName("shouldReturnDrawWinnerBet")
    void shouldReturnDrawWinnerBet() {
        BettingDto winBet = new BettingDto(new BigDecimal(0), new BigDecimal(0), new BigDecimal(100),
                new BigDecimal(1.20), new BigDecimal(1.70), new BigDecimal(2.0));
        Match winMatch = new Match(null, null, null, null, null);
        winMatch.setCompleted(true);
        winMatch.setHomeTeamScore(1);
        winMatch.setAwayTeamScore(1);

        BigDecimal result = bettingService.calculateBet(winBet, winMatch);

        Assertions.assertEquals(170, result.setScale(0, RoundingMode.CEILING).intValue());
    }

    @Test
    @DisplayName("shouldReturnGuestTeamWinnerBet")
    void shouldReturnGuestTeamWinnersBet() {
        BettingDto winBet = new BettingDto(new BigDecimal(0), new BigDecimal(100), new BigDecimal(0),
                new BigDecimal(1.20), new BigDecimal(1.70), new BigDecimal(2.0));
        Match winMatch = new Match(null, null, null, null, null);
        winMatch.setCompleted(true);
        winMatch.setHomeTeamScore(1);
        winMatch.setAwayTeamScore(3);

        BigDecimal result = bettingService.calculateBet(winBet, winMatch);

        Assertions.assertEquals(200, result.setScale(0, RoundingMode.CEILING).intValue());
    }

    @Test
    @DisplayName("shouldThrownRunTimeExceptionMatchIsNotOver")
    void shouldThrowRunTimeException() {
        BettingDto winBet = new BettingDto(new BigDecimal(0), new BigDecimal(100), new BigDecimal(0),
                new BigDecimal(1.20), new BigDecimal(1.70), new BigDecimal(2.0));
        Match winMatch = new Match(null, null, null, null, null);
        winMatch.setCompleted(false);
        winMatch.setHomeTeamScore(1);
        winMatch.setAwayTeamScore(3);

        RuntimeException ex = Assertions.assertThrows(RuntimeException.class, () -> bettingService.calculateBet(winBet, winMatch));
        assertTrue(ex.getMessage().contains("Match is not over yet!"));
    }
    @Test
    @DisplayName("shouldThrowNegativeBetException")
    void shouldThrowNegativeBetException() {
        BettingDto winBet = new BettingDto(new BigDecimal(-4), new BigDecimal(100), new BigDecimal(0),
                new BigDecimal(1.20), new BigDecimal(1.70), new BigDecimal(2.0));
        Match winMatch = new Match(null, null, null, null, null);
        winMatch.setCompleted(true);
        winMatch.setHomeTeamScore(1);
        winMatch.setAwayTeamScore(3);

        NegativeBetException ex = Assertions.assertThrows(NegativeBetException.class, () -> bettingService.calculateBet(winBet, winMatch));
        assertTrue(ex.getMessage().contains("Bet is less then 0!"));
    }

    @Test
    @DisplayName("shouldThrowWrongDateException")
    void shouldThrowWrongDateException() {
        BettingDto winBet = new BettingDto(new BigDecimal(-4), new BigDecimal(100), new BigDecimal(0),
                new BigDecimal(1.20), new BigDecimal(1.70), new BigDecimal(2.0));
        Match winMatch = new Match(LocalDateTime.of(2024, Month.APRIL, 25, 15, 00), null, null, null, null);
        winMatch.setCompleted(true);
        winMatch.setHomeTeamScore(1);
        winMatch.setAwayTeamScore(3);

        RuntimeException ex = Assertions.assertThrows(RuntimeException.class, () -> bettingService.calculateBet(winBet, winMatch));
        assertTrue(ex.getMessage().contains("Wrong date!"));
    }
}