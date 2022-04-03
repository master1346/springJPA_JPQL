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
                    var person = new Person()
                            .initBuilder(names.get(random.nextInt(names.size())),
                                    surname.get(random.nextInt(surname.size())),
                                    rnd(15, 60),
                                    "89513369216",
                                    city.get(random.nextInt(city.size()))
                                    );
                    entityManager.persist(person);
                        }
                        );
    }
}
