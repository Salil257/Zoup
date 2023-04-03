package com.zoup.orderapi.advice.exception;


public class ValidationException extends ServiceException {

    private static final long serialVersionUID = 1L;

    public ValidationException(ExceptionCode exceptionCode, String errorMessage) {
        super(exceptionCode, errorMessage);
    }
}
