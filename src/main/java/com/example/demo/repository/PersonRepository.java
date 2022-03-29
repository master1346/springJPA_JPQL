package com.example.demo.repository;

import com.example.demo.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface PersonRepository extends CrudRepository<Person,Integer> {

      List<Person> findByCity(String city);

      List<Person> findByAge(int age);

      Optional<Person> findByNameAndSurname(String name, String surname);

}
