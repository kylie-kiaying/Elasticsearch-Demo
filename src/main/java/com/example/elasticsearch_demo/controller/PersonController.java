package com.example.elasticsearch_demo.controller;

import com.example.elasticsearch_demo.model.Person;
import com.example.elasticsearch_demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/person")

public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        System.out.println(person);
        return personRepository.save(person);
    }

    @GetMapping
    public List<Person> findAllPersons() {
        Iterable<Person> people = personRepository.findAll();
        List<Person> resultList = new ArrayList<>();
        people.forEach(resultList::add);
        return resultList;
    }


    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable String id) {
        return personRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable String id) {
        personRepository.deleteById(id);
    }
}
