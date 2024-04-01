package com.tarasov.footballproject.exceptions.errorresponse;

import java.time.ZonedDateTime;

public class TeamErrorResponse {
    private Integer status;
    private String message;
    private ZonedDateTime timeStamp;

    public TeamErrorResponse() {
    }

    public TeamErrorResponse(Integer status, String message, ZonedDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(ZonedDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
