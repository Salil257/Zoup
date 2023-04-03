package com.zoup.orderapi.advice;


import com.zoup.orderapi.advice.exception.EntityNotFoundException;
import com.zoup.orderapi.dto.response.ErrorResponse;
import com.zoup.orderapi.advice.exception.ExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.UUID;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected @NonNull
    ResponseEntity<Object> handleMethodArgumentNotValid(
            @NonNull MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatus status,
            @NonNull WebRequest request) {
        String missingFields = ex.getFieldErrors().stream()
                .map(fieldError -> fieldError.getField()+" :: "+fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));

        var response = new ErrorResponse();
        response.setExceptionId(status.toString());
        response.setExceptionCode(status.toString());
        response.setException(missingFields);
        response.setStatusCode(status.value());

        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUnknownException(Exception exception) {
        return getErrorResponseResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, exception, ExceptionCode.U100);
    }

    private void printExceptionTrace(Exception exception, String errorId) {
        log.error("Error occurred. Error code :: " + errorId, exception);
    }

    private ResponseEntity<Object> getErrorResponseResponseEntity(HttpStatus errorCode, Exception exception, ExceptionCode exceptionCode) {
        var errorId = UUID.randomUUID().toString();
        printExceptionTrace(exception, errorId);
        var errorResponse = new ErrorResponse();
        errorResponse.setStatusCode(errorCode.value());
        errorResponse.setException(exception.getMessage());
        errorResponse.setExceptionId(errorId);
        errorResponse.setExceptionCode(exceptionCode.getCode());
        return new ResponseEntity<>(errorResponse, errorCode);
    }
}