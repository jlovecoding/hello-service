package com.example.hellokubernetes.controller;

import com.example.hellokubernetes.service.PersonNamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;

import static java.lang.String.format;
import static java.net.InetAddress.getLocalHost;

@RestController
public class HelloController {

    @Value("${helloService.greeter}")
    private String greeter;

    @Autowired
    private PersonNamesService personNamesService;

    @GetMapping("/hello")
    public String hello() {
        return format("from-%s-%s says: hello %s", getLocalIp(), greeter, personNamesService.getPersonName());
    }

    private String getLocalIp() {
        String localIp = "unknown";
        try {
            localIp = getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return localIp;
    }
}
