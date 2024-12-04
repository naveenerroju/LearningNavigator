package com.naveen.learningnavigator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NumberFactsService implements INumberFactsService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getFact(int number) {
        String url = "http://numbersapi.com/"+number;

        return restTemplate.getForObject(url, String.class);
    }
}
