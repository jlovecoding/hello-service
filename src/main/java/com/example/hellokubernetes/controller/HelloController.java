package com.example.hellokubernetes.controller;

import com.example.hellokubernetes.model.PersonName;
import com.example.hellokubernetes.service.PersonNamesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.List;

import static java.lang.String.format;
import static java.net.InetAddress.getLocalHost;

@RestController
@Slf4j
public class HelloController {

    @Value("${helloService.greeter}")
    private String greeter;

    @Autowired
    private PersonNamesService personNamesService;

    @GetMapping("/hello/random")
    public String helloRandom() {
        return format("from-%s-%s says: hello %s", getLocalIp(), greeter,
                personNamesService.getRandomPersonNames().get(0).getPersonName());
    }

    @GetMapping("/hello")
    public String hello() {
        List<PersonName> personNames = personNamesService.getPersonNames();
        return format("from-%s-%s says: hello %s", getLocalIp(), greeter,
                personNames.get(personNames.size() - 1).getPersonName());
    }

    private String getLocalIp() {
        String localIp = "unknown";
        try {
            localIp = getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error("Error getting local IP", e);
        }

        return localIp;
    }
}
