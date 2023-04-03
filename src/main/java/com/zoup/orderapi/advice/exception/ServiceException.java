package com.zoup.orderapi.advice.exception;

import lombok.Getter;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @Getter
    private final ExceptionCode exceptionCode;

    public ServiceException(ExceptionCode exceptionCode, String errorMessage) {
        super(errorMessage);
        this.exceptionCode = exceptionCode;
    }

    public ServiceException(ExceptionCode exceptionCode, Throwable cause, String errorMessage) {
        super(errorMessage, cause);
        this.exceptionCode = exceptionCode;
    }
}
