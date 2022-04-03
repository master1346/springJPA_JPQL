package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

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

    @GetMapping("/read&write")
    @Secured({"READ"})
    public static String readWrite () {
        return "Hello user role read and write";
    }

    @GetMapping("/read")
    @RolesAllowed("WRITE")
    public static String read () {
        return "Hello user role read";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasRole(WRITE) or hasRole(DELETE)")
    public static String delete () {
        return "Hello user role delete";
    }

    @GetMapping("/queryuser")
    @PreAuthorize("#username = authentication.username")
    public static String queryUser (@RequestParam("user") String username) {
        return "Hello user queryuser " + username;
    }
}
