package com.autocompletesearch.consumer;

import com.autocompletesearch.model.PrefixMap;
import com.autocompletesearch.service.PrefixMapUpdaterService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class AutoCompleteListener {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PrefixMapUpdaterService prefixMapUpdaterService;

    @KafkaListener(topics = "${spring.kafka.topic}",groupId = "${spring.kafka.groupId}")
    public void consumeAutoCompleteMessage(@Payload String message){
        try{
            log.info("Start consumeAutoCompleteMessage");
            Map<String, String> prefixMap = objectMapper.readValue(message, new TypeReference<Map<String, String>>() {});
            prefixMapUpdaterService.updatePrefixMap(prefixMap);
            log.info("End consumeAutoCompleteMessage");
        }
        catch (Exception e){
            log.error("Exception occurred while consumeAutoCompleteMessage :{}",e.getMessage(),e);
        }
    }
}
