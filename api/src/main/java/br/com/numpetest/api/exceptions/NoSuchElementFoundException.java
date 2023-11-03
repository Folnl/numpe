package br.com.numpetest.api.exceptions;

import org.springframework.http.HttpStatus;

public class NoSuchElementFoundException extends ResponseException {

  public NoSuchElementFoundException(String message) {
    super(HttpStatus.NOT_FOUND, message);
  }

}
