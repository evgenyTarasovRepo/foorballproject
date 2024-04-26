package com.tarasov.footballproject.dto.testdto;

import java.math.BigDecimal;

public class BettingDto {
    private BigDecimal homeTeamBetSum;
    private BigDecimal guestTeamBetSum;
    private BigDecimal drawTeamBetSum;
    private BigDecimal homeTeamWinnerCoefficient;
    private BigDecimal drawCoefficient;
    private BigDecimal guestTeamWinnerCoefficient;

    public BettingDto() {
    }

    public BettingDto(BigDecimal homeTeamBetSum, BigDecimal guestTeamBetSum,
                      BigDecimal drawTeamBetSum, BigDecimal homeTeamWinnerCoefficient,
                      BigDecimal drawCoefficient, BigDecimal guestTeamWinnerCoefficient) {
        this.homeTeamBetSum = homeTeamBetSum;
        this.guestTeamBetSum = guestTeamBetSum;
        this.drawTeamBetSum = drawTeamBetSum;
        this.homeTeamWinnerCoefficient = homeTeamWinnerCoefficient;
        this.drawCoefficient = drawCoefficient;
        this.guestTeamWinnerCoefficient = guestTeamWinnerCoefficient;
    }

    public BigDecimal getHomeTeamBetSum() {
        return homeTeamBetSum;
    }

    public void setHomeTeamBetSum(BigDecimal homeTeamBetSum) {
        this.homeTeamBetSum = homeTeamBetSum;
    }

    public BigDecimal getGuestTeamBetSum() {
        return guestTeamBetSum;
    }

    public void setGuestTeamBetSum(BigDecimal guestTeamBetSum) {
        this.guestTeamBetSum = guestTeamBetSum;
    }

    public BigDecimal getDrawTeamBetSum() {
        return drawTeamBetSum;
    }

    public void setDrawTeamBetSum(BigDecimal drawTeamBetSum) {
        this.drawTeamBetSum = drawTeamBetSum;
    }

    public BigDecimal getHomeTeamWinnerCoefficient() {
        return homeTeamWinnerCoefficient;
    }

    public void setHomeTeamWinnerCoefficient(BigDecimal homeTeamWinnerCoefficient) {
        this.homeTeamWinnerCoefficient = homeTeamWinnerCoefficient;
    }

    public BigDecimal getDrawCoefficient() {
        return drawCoefficient;
    }

    public void setDrawCoefficient(BigDecimal drawCoefficient) {
        this.drawCoefficient = drawCoefficient;
    }

    public BigDecimal getGuestTeamWinnerCoefficient() {
        return guestTeamWinnerCoefficient;
    }

    public void setGuestTeamWinnerCoefficient(BigDecimal guestTeamWinnerCoefficient) {
        this.guestTeamWinnerCoefficient = guestTeamWinnerCoefficient;
    }
}
