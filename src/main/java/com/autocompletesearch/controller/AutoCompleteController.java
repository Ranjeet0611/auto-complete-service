package com.autocompletesearch.controller;

import com.autocompletesearch.model.SuccessResponse;
import com.autocompletesearch.service.AutoCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/autocomplete/v1")
public class AutoCompleteController {
    @Autowired
    private AutoCompleteService autoCompleteService;
    @GetMapping(path = "/search")
    public ResponseEntity<SuccessResponse<Set<String>>> getSuggestions(@RequestParam("query") String query){
        SuccessResponse<Set<String>> successResponse = new SuccessResponse.SuccessResponseBuilder<Set<String>>().
                setData(autoCompleteService.getSuggestions(query)).
                setStatus(HttpStatus.OK.name()).
                setTime().
                build();
        return ResponseEntity.ok(successResponse);
    }
}
