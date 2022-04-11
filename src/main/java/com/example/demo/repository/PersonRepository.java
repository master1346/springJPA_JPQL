package com.example.demo.repository;

import com.example.demo.entity.Person;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class PersonRepository {

      @PersistenceContext
      private EntityManager entityManager;

      public String getPersonsByCity(String city){
            Query query = entityManager.createQuery("select p from Person p where p.city = :city", Person.class);
            var resultList = query.setParameter("city", city);
            return resultList.getResultList().toString();
      }
}
