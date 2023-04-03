package com.zoup.orderapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Optional;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

    private Integer statusCode = 200;
    private String statusMessage = "success";


    public void setStatusCode(Integer statusCode) {
        Optional.ofNullable(statusCode).ifPresent(sc -> this.statusCode = sc);
    }

    public void setStatusMessage(String statusMessage) {
        Optional.ofNullable(statusMessage).ifPresent(sm -> this.statusMessage = sm);
    }

}
