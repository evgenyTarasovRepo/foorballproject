package com.tarasov.footballproject.exceptions;

public class NegativeBetException extends RuntimeException{
    public NegativeBetException(String message) {
        super(message);
    }
}
