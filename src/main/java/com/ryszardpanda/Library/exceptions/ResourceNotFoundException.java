package com.ryszardpanda.Library.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private final HttpStatus statusHttp;

    public ResourceNotFoundException(String message, HttpStatus statusHttp) {
        super(message);
        this.statusHttp = statusHttp;
    }
}