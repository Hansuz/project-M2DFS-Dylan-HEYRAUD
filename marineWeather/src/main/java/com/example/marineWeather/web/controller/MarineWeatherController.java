package com.example.marineWeather.web.controller;

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
public class MarineWeatherController {

    @Autowired
    RestTemplate restTemplate;

    /*
    @ApiOperation(value = "Get details for weather", response = MarineWeatherController.class, tags = "getWeather")
    @RequestMapping(value = "/Weather/{key}", method = RequestMethod.GET)
    public String getWeather(@PathVariable String key) {
        String response = restTemplate.exchange("http://dataservice.accuweather.com/currentconditions/v1/{key}?apikey=1S8eDxJkj8iHWAaf3XbuMAhGQMgQOEpS&language=fr-fr",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, key).getBody();
        return response;
    }
    */

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
