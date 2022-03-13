package com.example.demo.service;


import com.example.demo.repository.JdbcOrdersRepository;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private final JdbcOrdersRepository repository;

    public DemoService(JdbcOrdersRepository repository){ this.repository = repository; }

    public String getProductName(String name){
      return repository.getProductName(name);
    }


}
