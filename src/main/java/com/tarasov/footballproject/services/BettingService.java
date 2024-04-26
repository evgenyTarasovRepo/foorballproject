package com.tarasov.footballproject.services;

import com.tarasov.footballproject.dto.testdto.BettingDto;
import com.tarasov.footballproject.entities.Match;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BettingService {

    public BigDecimal calculateBet(BettingDto bet, Match match){
        if (match.getCompleted()) {

            if (bet.getHomeTeamBetSum().compareTo(BigDecimal.ZERO) > 0 && (match.getHomeTeamScore() > match.getAwayTeamScore())) {
                return bet.getHomeTeamBetSum().multiply(bet.getHomeTeamWinnerCoefficient());
            }
            else if (bet.getGuestTeamBetSum().compareTo(BigDecimal.ZERO) > 0 && (match.getHomeTeamScore() < match.getAwayTeamScore())) {
                return bet.getGuestTeamBetSum().multiply(bet.getGuestTeamWinnerCoefficient());
            }
            else if (bet.getDrawTeamBetSum().compareTo(BigDecimal.ZERO) > 0 && (match.getHomeTeamScore().equals(match.getAwayTeamScore()))) {
                return bet.getDrawTeamBetSum().multiply(bet.getDrawCoefficient());
            }
        }
        if(!match.getCompleted()) {
            throw new RuntimeException("Match is not over yet!");
        }
        return null;
    }
}
