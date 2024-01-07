package com.autocompletesearch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Getter
@Setter
@Document(collection = "auto_complete_suggestions")
@AllArgsConstructor
public class AutoComplete {

    @Id
    private String id;
    private String prefix;
    private Set<String> topWords;
}
