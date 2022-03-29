package com.example.demo;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
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
    public static int rnd(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
        }
    @Override
    @Transactional
    public void run(String... args) {
        var names = List.of("Алексей", "Антон","Борис", "Валерий");
        var surname =  List.of("Иванов", "Гаврилов","Федоров", "Ветров");
        var city =  List.of("Москва", "Питер","Казань", "Тверь");
        var random = new Random();

        IntStream.range(0, 15)
                .forEach(i -> {
                    var person =
                            new Person.Builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surname.get(random.nextInt(surname.size())))
                            .age(rnd(15, 60))
                            .phone_number("89513369216")
                            .city(city.get(random.nextInt(city.size())))
                            .build();

                    entityManager.persist(person);
                        }
                        );

    }
}
