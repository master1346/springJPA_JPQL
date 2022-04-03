package com.example.demo.service;


import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemoService {

    private final PersonRepository personRepository;

    public DemoService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getEntityByCity(String city){
        return  personRepository.findByCity(city);
    }

    public List<Person> getEntityByAge(int age){
        return  personRepository.findByAge(age);
    }

    public Optional<Person> getEntityByNameAndSurname(String name, String surname){
        return personRepository.findByNameAndSurname(name, surname);
    }

}
