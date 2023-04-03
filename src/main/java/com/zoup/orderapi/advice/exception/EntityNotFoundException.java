package com.zoup.orderapi.advice.exception;

public class EntityNotFoundException extends ServiceException {

    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(ExceptionCode exceptionCode, String errorMessage) {
        super(exceptionCode, errorMessage);
    }

}
