package com.autocompletesearch.service.impl;

import com.autocompletesearch.Repository.AutoCompleteRepository;
import com.autocompletesearch.model.AutoComplete;
import com.autocompletesearch.service.PrefixMapUpdaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
@Slf4j
public class PrefixMapUpdaterImpl implements PrefixMapUpdaterService {
    @Autowired
    private AutoCompleteRepository autoCompleteRepository;

    @Override
    public void updatePrefixMap(Map<String,String> prefixMap) {
        log.info("Start updatePrefixMap");
        try{
            prefixMap.forEach((key,value)->{
                List<AutoComplete> autoCompleteList = autoCompleteRepository.findByQuery(key);
                if(CollectionUtils.isEmpty(autoCompleteList)){
                    createAutoCompleteSuggestions(prefixMap);
                    return;
                }
                Set<String> topWords = autoCompleteList.get(0).getTopWords();
                topWords.add(value);
                autoCompleteList.get(0).setTopWords(topWords);
                autoCompleteRepository.save(autoCompleteList.get(0));
            });
        }
        catch(Exception e) {
            log.error("Exception occurred while updatePrefixMap :{}", e.getMessage(), e);
        }
        log.info("End updatePrefixMap");
    }

    private void createAutoCompleteSuggestions(Map<String, String> prefixMap) {
        List<AutoComplete> autoCompleteList = new ArrayList<>();
        prefixMap.forEach((key,value)->{
            autoCompleteList.add(new AutoComplete(UUID.randomUUID().toString(),key,Collections.singleton(value)));
        });
        autoCompleteRepository.saveAll(autoCompleteList);
    }
}
