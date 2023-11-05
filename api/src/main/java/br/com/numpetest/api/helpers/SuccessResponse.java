package br.com.numpetest.api.helpers;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

public class SuccessResponse<T> extends Response {

    @Getter
    @Setter
    private T data;

    public SuccessResponse(HttpStatus status, T data) {
        super(status, true);
        this.data = data;
    }
}
