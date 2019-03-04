package com.example.hellokubernetes.controller;

import com.example.hellokubernetes.service.PersonNamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${helloService.greeter}")
    private String greeter;

    @Autowired
    private PersonNamesService personNamesService;

    @GetMapping("/hello")
    public String hello() {
        return greeter + " says: hello " + personNamesService.getPersonName();
    }
}
