package com.example.hellokubernetes.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonNamesService {

    @Value("${personNamesService.url}")
    private String personNamesServiceUrl;

    public String getPersonName() {
        return new RestTemplate().getForEntity(personNamesServiceUrl, String.class).getBody();
    }
}
