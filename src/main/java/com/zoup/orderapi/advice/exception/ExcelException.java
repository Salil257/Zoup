package com.zoup.orderapi.advice.exception;


public class ExcelException extends ServiceException {

    public ExcelException(ExceptionCode exceptionCode, String errorMessage) {
        super(exceptionCode, errorMessage);
    }
}
