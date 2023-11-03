package br.com.numpetest.api.helpers;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class RestResponse<T> {

    @Getter
    @Setter
    private HttpStatus statusCode;

    @Getter
    @Setter
    private Boolean success;

    @Getter
    @Setter
    private T data;
}
