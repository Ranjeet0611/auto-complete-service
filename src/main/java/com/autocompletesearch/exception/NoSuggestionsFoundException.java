package com.autocompletesearch.exception;

public class NoSuggestionsFoundException extends RuntimeException{
    private String message;
    public NoSuggestionsFoundException(String message){
        this.message = message;
    }
}
