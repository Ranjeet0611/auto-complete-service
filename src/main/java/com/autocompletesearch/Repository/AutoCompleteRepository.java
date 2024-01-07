package com.autocompletesearch.Repository;

import com.autocompletesearch.model.AutoComplete;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoCompleteRepository extends MongoRepository<AutoComplete,String>,CustomAutoCompleteRepository {
}
