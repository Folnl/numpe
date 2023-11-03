package br.com.numpetest.api.helpers;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

public abstract class Response {

    @Getter
    @Setter
    private int statusCode;

    @Getter
    @Setter
    private Boolean success = null;

    public Response(HttpStatus statusCode, Boolean success) {
        this.statusCode = statusCode.value();
        this.success = success;
    }
}
