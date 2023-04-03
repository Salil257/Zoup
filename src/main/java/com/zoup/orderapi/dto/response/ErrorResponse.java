package com.zoup.orderapi.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ErrorResponse extends ResponseDTO {

    private String requestId;
    private String exceptionId;
    private String exception;
    private String exceptionCode;

    public void setException(String exception) {
        this.exception = exception;
        this.setStatusMessage("Error occurred");
    }
}
