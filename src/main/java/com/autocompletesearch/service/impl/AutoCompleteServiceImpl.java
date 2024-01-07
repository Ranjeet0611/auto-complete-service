package com.autocompletesearch.service.impl;

import com.autocompletesearch.Repository.AutoCompleteRepository;
import com.autocompletesearch.exception.NoSuggestionsFoundException;
import com.autocompletesearch.model.AutoComplete;
import com.autocompletesearch.service.AutoCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

@Service
public class AutoCompleteServiceImpl implements AutoCompleteService {

    @Autowired
    private AutoCompleteRepository autoCompleteRepository;
    @Override
    public Set<String> getSuggestions(String query) {
        List<AutoComplete> autoCompleteList = autoCompleteRepository.findByQuery(query);
        if(CollectionUtils.isEmpty(autoCompleteList)){
            throw new NoSuggestionsFoundException("No suggestions found");
        }
        AutoComplete autoComplete = autoCompleteList.get(0);
        return autoComplete.getTopWords();
    }
}
