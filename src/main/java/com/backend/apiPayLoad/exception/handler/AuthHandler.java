package com.backend.apiPayLoad.exception.handler;


import com.backend.apiPayLoad.code.status.ErrorStatus;

public class AuthHandler extends RuntimeException {

    private final ErrorStatus errorStatus;

    public AuthHandler(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }

    public ErrorStatus getErrorStatus() {
        return errorStatus;
    }
}