package com.backend.apiPayLoad.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorStatus {

    _PARSING_ERROR(400, "JSON Parsing Error"),
    _INVALID_ACCESS(401, "Invalid Access Code"),
    _USER_NOT_FOUND(404, "User Not Found");

    private final int statusCode;
    private final String message;
}