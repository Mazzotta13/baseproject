package com.alessio.baseproject.model;

public enum  ErrorInfo {
    GENERIC(500, "Generic Error");

    private int errorCode;
    private String message;


    ErrorInfo(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }


    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
