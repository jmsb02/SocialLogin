package com.backend.apiPayLoad.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {

    private int status;
    private String message;
    private T data;

    public static <T> BaseResponse<T> onSuccess(T data) {
        return new BaseResponse<>(200, "Success", data);
    }

    public static <T> BaseResponse<T> onFailure(String message, int status) {
        return new BaseResponse<>(status, message, null);
    }
}