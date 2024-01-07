package com.autocompletesearch.exception.advice;

import com.autocompletesearch.exception.NoSuggestionsFoundException;
import com.autocompletesearch.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {NoSuggestionsFoundException.class})
    public ResponseEntity<ErrorResponse> handleNoSuggestionFoundException(NoSuggestionsFoundException e, WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder().setErrorMessage(e.getMessage()).setStatus(HttpStatus.NOT_FOUND.name()).setTime().build();
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
