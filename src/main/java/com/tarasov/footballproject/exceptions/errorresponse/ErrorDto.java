package com.tarasov.footballproject.exceptions.errorresponse;

import java.util.Map;

public class ErrorDto {
    private String code;
    private String message;
    private Map<String, Object> fields;

    public ErrorDto() {
    }

    public ErrorDto(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorDto(String code, String message, Map<String, Object> fields) {
        this.code = code;
        this.message = message;
        this.fields = fields;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }
}
