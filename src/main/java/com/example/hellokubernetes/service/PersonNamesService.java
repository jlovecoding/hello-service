package com.example.hellokubernetes.service;

import com.example.hellokubernetes.model.PersonName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpMethod.GET;

@Service
public class PersonNamesService {

    private String personNamesServiceUrl;
    private String personNamesRandomServiceUrl;

    public PersonNamesService(@Value("${personNamesService.url}") final String personNamesServiceUrl) {
        this.personNamesServiceUrl = personNamesServiceUrl;
        this.personNamesRandomServiceUrl = personNamesServiceUrl + "/random";
    }

    public List<PersonName> getRandomPersonNames() {
        List<PersonName> personNames = new RestTemplate().exchange(personNamesRandomServiceUrl, GET, null,
                new ParameterizedTypeReference<List<PersonName>>() {
                }).getBody();

        return personNames
                .stream()
                .map(this::updatePersonName)
                .collect(toList());
    }

    public List<PersonName> getPersonNames() {
        return new RestTemplate().exchange(personNamesServiceUrl, GET, null,
                new ParameterizedTypeReference<List<PersonName>>() {
                })
                .getBody();

    }

    private PersonName updatePersonName(PersonName personName) {
        return personName.toBuilder()
                .personName(format("fromUrl-%s-%s", personNamesRandomServiceUrl, personName.getPersonName()))
                .build();
    }
}
