package com.example.hellokubernetes.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;

@Service
public class PersonNamesService {

    @Value("${personNamesService.url}")
    private String personNamesServiceUrl;

    public String getPersonName() {
        return format("fromUrl-%s-%s", personNamesServiceUrl,
                new RestTemplate().getForEntity(personNamesServiceUrl, String.class).getBody());
    }
}
