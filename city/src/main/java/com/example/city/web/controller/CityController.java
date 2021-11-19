package com.example.city.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CityController {
    @Autowired
    RestTemplate restTemplate;

    String city;

    @ApiOperation(value = "Get details for city", response = CityController.class, tags = "getCity")
    @RequestMapping(value = "/City/{city}", method = RequestMethod.GET)
    public String getCity(@PathVariable String city) {
        String response = restTemplate.exchange("http://dataservice.accuweather.com/locations/v1/cities/search?apikey=1S8eDxJkj8iHWAaf3XbuMAhGQMgQOEpS&q=" + city + "&language=fr-fr",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, city).getBody();
        return response;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
