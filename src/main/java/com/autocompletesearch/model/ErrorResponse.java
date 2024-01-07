package com.autocompletesearch.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class ErrorResponse {
    private final String status;
    private final String errorMessage;
    private final long time;
    public ErrorResponse(ErrorResponseBuilder errorResponseBuilder){
        this.status = errorResponseBuilder.status;
        this.errorMessage = errorResponseBuilder.errorMessage;
        this.time = errorResponseBuilder.time;
    }
    public static class ErrorResponseBuilder{
        private String status;
        private String errorMessage;
        private long time;

        public ErrorResponseBuilder setStatus(String status) {
            this.status = status;
            return this;
        }
        public ErrorResponseBuilder setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }
        public ErrorResponseBuilder setTime() {
            this.time = new Date().getTime();
            return this;
        }
        public ErrorResponse build(){
            return new ErrorResponse(this);
        }
    }
}
