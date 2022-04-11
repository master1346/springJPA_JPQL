package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoService service;

    public DemoController(DemoService service){ this.service = service;}

    @GetMapping(value = "/persons/by-city")
    public String getPersonByCity(@RequestParam("city") String city){
      return service.getPersonByCity(city);
    }

    @GetMapping(value = "/")
    public String hello(){
        return "Hello";
    }

}
