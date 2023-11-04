package br.com.numpetest.api.exceptions;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import br.com.numpetest.api.helpers.ErrorResponse;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ErrorResponse handleNoSuchElementFoundException(NoSuchElementFoundException exception) {
        return new ErrorResponse(exception.getStatus(), exception.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorResponse handleConstraintViolationException(
            ConstraintViolationException exception) {
        List<String> errors = Collections.singletonList(exception.getMessage());
        return new ErrorResponse(HttpStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(ResponseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorResponse handleResponseException(
            ResponseException exception) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorResponse handleIllegalArgumentException(
            IllegalArgumentException exception) {
        List<String> errors = Collections.singletonList(exception.getMessage());
        return new ErrorResponse(HttpStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorResponse handleHttpMessageNotReadableException(
            HttpMessageNotReadableException exception) {
        List<String> errors = Collections.singletonList(exception.getMessage());
        return new ErrorResponse(HttpStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorResponse handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, "Parâmetro incorreto");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ErrorResponse handleGeneralExceptions(Exception exception) {
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                "Error interno do servidor, entre em contato com um administrador do sistema.");
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ErrorResponse handleRuntimeExceptions(RuntimeException exception) {
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                "Error interno do servidor, entre em contato com um administrador do sistema.");
    }
}
