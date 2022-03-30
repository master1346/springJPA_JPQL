package com.example.demo.repository;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface PersonRepository extends CrudRepository<Person,Integer> {

 //     List<Person> findByCity(String city);
 //     List<Person> findByAge(int age);
 //     Optional<Person> findByNameAndSurname(String name, String surname);

        @Query("select e from Person e where e.city = :city")
         List<Person> findByCityQuery(@Param("city") String city);

         @Query("select e from Person e where e.age = :age")
         List<Person> findByAgeQuery(@Param("age") int age);

         @Query("select e from Person e where e.name = :name and e.surname = :surname")
         List<Person> findByNameAndSurnameQuery(@Param("name") String name, @Param("surname") String surname);


}
