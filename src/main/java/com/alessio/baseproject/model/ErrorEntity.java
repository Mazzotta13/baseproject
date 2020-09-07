package com.alessio.baseproject.model;

public class ErrorEntity {
    private int applicationErrorCode;
    private String message;

    public int getApplicationErrorCode() {
        return applicationErrorCode;
    }

    public ErrorEntity setApplicationErrorCode(int applicationErrorCode) {
        this.applicationErrorCode = applicationErrorCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorEntity setMessage(String message) {
        this.message = message;
        return this;
    }
}
