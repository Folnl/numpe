package br.com.numpetest.api.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class ResponseException extends RuntimeException {

    @Getter
    private HttpStatus status;

    @Getter
    private List<String> errors;

    @Getter
    private String message;

    public ResponseException(HttpStatus status, List<String> errors, String message) {
        super();
        this.status = status;
        this.errors = errors;
        this.message = message;
    }

    public ResponseException(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
}
