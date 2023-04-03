package com.zoup.orderapi.advice.exception;

public class TenantAliasNotFoundException extends RuntimeException {
    public TenantAliasNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public TenantAliasNotFoundException(String msg) {
        super(msg);
    }
}
