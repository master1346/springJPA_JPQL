package com.example.demo.service;


import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    private final PersonRepository personRepository;

    public DemoService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public String getEntityByCity(String city){
        return  personRepository.findByCity(city).toString();
    }

    public String getEntityByAge(int age){
        return  personRepository.findByAge(age).toString();
    }

    public String getEntityByNameAndSurname(String name, String surname){
        return personRepository.findByNameAndSurname(name, surname).toString();
    }

}
