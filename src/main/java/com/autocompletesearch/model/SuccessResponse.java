package com.autocompletesearch.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class SuccessResponse<T> {
    private final String status;
    private final T data;
    private final long time;
    public SuccessResponse (SuccessResponseBuilder<T> successResponseBuilder){
        this.status = successResponseBuilder.status;
        this.data = successResponseBuilder.data;
        this.time = successResponseBuilder.time;
    }
    public static class SuccessResponseBuilder<T>{
        private String status;
        private T data;
        private long time;
        public SuccessResponseBuilder<T> setStatus(String status) {
            this.status = status;
            return this;
        }

        public SuccessResponseBuilder<T> setData(T data) {
            this.data = data;
            return this;
        }

        public SuccessResponseBuilder<T> setTime() {
            this.time = new Date().getTime();
            return this;
        }
        public SuccessResponse<T> build(){
            return new SuccessResponse<>(this);
        }
    }
}
