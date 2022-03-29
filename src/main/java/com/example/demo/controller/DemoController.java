package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final DemoService service;

    public DemoController(DemoService service){ this.service = service;}

    @GetMapping(value = "/persons/by-city", params = "city")
    public String getEntityCity(@RequestParam("city") String city){
      return service.getEntityByCity(city);
    }

    @GetMapping(value = "/persons/by-city", params = "age")
    public String getEntityByAge(@RequestParam("age") int age){
        return service.getEntityByAge(age);
    }

    @GetMapping(value = "/persons/by-city")
    public String getEntityByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname){
        return service.getEntityByNameAndSurname(name, surname);
    }


    @GetMapping("/")
    public static String hello () {
        return "Hello user";
    }

}
