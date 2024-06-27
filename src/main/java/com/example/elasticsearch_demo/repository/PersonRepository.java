package com.example.elasticsearch_demo.repository;

import com.example.elasticsearch_demo.model.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PersonRepository extends ElasticsearchRepository<Person, String> {
}