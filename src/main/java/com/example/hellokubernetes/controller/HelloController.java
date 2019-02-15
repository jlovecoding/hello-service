package com.example.hellokubernetes.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class HelloController {

    @Value("${helloService.greeter}")
    private String greeter;

    @GetMapping("/hello")
    public String hello(@PathParam("name") final String name) {
        return greeter + " says: hello " + name;
    }
}
