package com.example.training;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountriesRepository extends MongoRepository<Countries, String> {

}

