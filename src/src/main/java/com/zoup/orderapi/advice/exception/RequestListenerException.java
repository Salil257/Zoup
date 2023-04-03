package com.zoup.orderapi.advice.exception;

public class RequestListenerException extends RuntimeException{

    public RequestListenerException(String message) {
        super(message);
    }
}
