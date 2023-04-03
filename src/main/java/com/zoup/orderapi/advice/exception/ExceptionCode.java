package com.zoup.orderapi.advice.exception;

import lombok.Getter;

public enum ExceptionCode {


    B104("B!04", "Bill not found"),
    O404("O404", "Order Not Found"),

    V101("V101", "Validation error"),

    V104("V104", "email already exist in mailing list"),
    U100("U100", "Unknown exception occurred."),
    T404("T404", "Table not found"),

    P404("P404", "Product Not Found"),

    S404("S404", "Store Not Found"),
    PC404("PC404", "Product Category Not Found");

    @Getter
    private final String code;

    @Getter
    private final String defaultMessage;

    ExceptionCode(String code, String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }
}
