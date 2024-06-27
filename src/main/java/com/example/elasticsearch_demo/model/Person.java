package com.example.elasticsearch_demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "person")
public class Person {
    @Id
    private String id;
    private String name;
    private int age;
}
