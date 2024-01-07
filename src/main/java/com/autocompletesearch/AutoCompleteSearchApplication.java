package com.autocompletesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableMongoRepositories
@EnableKafka
public class AutoCompleteSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoCompleteSearchApplication.class, args);
	}

}
