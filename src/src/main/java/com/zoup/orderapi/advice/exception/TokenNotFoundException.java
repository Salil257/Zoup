package com.zoup.orderapi.advice.exception;


public class TokenNotFoundException extends EntityNotFoundException {

    public TokenNotFoundException(ExceptionCode exceptionCode, String errorMessage) {
        super(exceptionCode, errorMessage);
    }
}
