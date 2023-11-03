package br.com.numpetest.api.helpers;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

public class ErrorResponse extends Response {

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private List<String> errors;

    public ErrorResponse(HttpStatus status, String message) {
        super(status, false);
        this.message = message;
    }

    public ErrorResponse(HttpStatus status, List<String> errors) {
        super(status, false);
        this.errors = errors;
    }

    public ErrorResponse(HttpStatus status, String message, List<String> errors) {
        super(status, false);
        this.message = message;
        this.errors = errors;
    }
}
