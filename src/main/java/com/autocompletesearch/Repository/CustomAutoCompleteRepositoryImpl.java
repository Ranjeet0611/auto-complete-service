package com.autocompletesearch.Repository;

import com.autocompletesearch.model.AutoComplete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
public class CustomAutoCompleteRepositoryImpl implements CustomAutoCompleteRepository {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<AutoComplete> findByQuery(String query){
        Query customQuery = new Query(Criteria.where("prefix").is(query));
        return mongoTemplate.find(customQuery, AutoComplete.class);
    }
}
