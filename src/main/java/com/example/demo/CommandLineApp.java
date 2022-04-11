package com.example.demo;

import com.example.demo.entity.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class CommandLineApp implements CommandLineRunner {
   @PersistenceContext
   private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) {
        var names = List.of("Алексей", "Антон","Борис", "Валерий", "Кирилл","Женя","Федор");
        var surname =  List.of("Иванов", "Гаврилов","Федоров", "Ветров","Петров","Азаров","Эмин");
        var city =  List.of("Москва", "Питер");
        var age = List.of(20,21,44,60,53,31,35);
        var random = new Random();

        IntStream.range(0, 6)
                .forEach(i -> {
                    var person = new Person()
                            .initBuilder(new Person.PersonData(
                                    names.get(i),
                                    surname.get(i),
                                    age.get(i)),
                                    "89513369216",
                                    city.get(random.nextInt(city.size()))
                                    );
                    entityManager.persist(person);
                        }
                        );
    }
}