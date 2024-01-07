package com.autocompletesearch.service;

import java.util.Set;

public interface AutoCompleteService {
    Set<String> getSuggestions(String query);
}
