package com.autocompletesearch.Repository;

import com.autocompletesearch.model.AutoComplete;

import java.util.List;

public interface CustomAutoCompleteRepository {
    List<AutoComplete> findByQuery(String query);
}
