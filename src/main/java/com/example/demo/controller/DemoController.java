package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final DemoService service;

    public DemoController(DemoService service){ this.service = service;}

    @GetMapping("/products/fetch-product")
    public String getProductName(@RequestParam("name") String name){
       return service.getProductName(name);
    }

    @GetMapping("/")
    public static String hello () {
        return "Hello user";
    }

}
