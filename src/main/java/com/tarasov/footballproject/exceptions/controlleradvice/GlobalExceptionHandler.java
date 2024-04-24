package com.tarasov.footballproject.exceptions.controlleradvice;

import com.tarasov.footballproject.exceptions.TeamNotFoundException;
import com.tarasov.footballproject.exceptions.errorresponse.ErrorDto;
import com.tarasov.footballproject.exceptions.errorresponse.TeamErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler({HttpServerErrorException.InternalServerError.class})
    public ResponseEntity<Object> handleInternalError(HttpServerErrorException.InternalServerError ex, WebRequest request) {
        logger.error(ex.getMessage(), ex);
        ErrorDto error = new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> handleBadRequest(BadRequestException ex, WebRequest request) {
        ErrorDto error = new ErrorDto(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        ErrorDto error = new ErrorDto(HttpStatus.NOT_FOUND.toString(), "Entity with does not exists");
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<Object> handleNoSuchElement(NoSuchElementException ex, WebRequest request) {
        ErrorDto error = new ErrorDto(HttpStatus.NOT_FOUND.toString(), "Element does not exists");
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {TeamNotFoundException.class})
    public ResponseEntity<TeamErrorResponse> handleTeamException(TeamNotFoundException exc) {
        TeamErrorResponse teamErrorResponse = new TeamErrorResponse();
        teamErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        teamErrorResponse.setMessage(exc.getMessage());
        teamErrorResponse.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(teamErrorResponse, HttpStatus.NOT_FOUND);
    }
}
