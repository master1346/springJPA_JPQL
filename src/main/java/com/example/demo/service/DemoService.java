package com.example.demo.service;

import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    private final PersonRepository personRepository;

    public DemoService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public String getPersonByCity(String city) {
        return personRepository.getPersonsByCity(city);
    }
}
