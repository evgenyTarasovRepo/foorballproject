package com.tarasov.footballproject.exceptions.controlleradvice;

import com.tarasov.footballproject.exceptions.TeamNotFoundException;
import com.tarasov.footballproject.exceptions.errorresponse.TeamErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class TeamExceptionHandler {

    @ExceptionHandler(value = {TeamNotFoundException.class})
    public ResponseEntity<TeamErrorResponse> handleTeamException(TeamNotFoundException exc) {
        TeamErrorResponse teamErrorResponse = new TeamErrorResponse();
        teamErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        teamErrorResponse.setMessage(exc.getMessage());
        teamErrorResponse.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(teamErrorResponse, HttpStatus.NOT_FOUND);
    }
}
