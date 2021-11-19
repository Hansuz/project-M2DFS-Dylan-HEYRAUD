package com.example.marineWeather.web.controller;

import com.example.marineWeather.model.MarineWeather;
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

    String city;

    @ApiOperation(value = "Get details for marine weather in their port", response = MarineWeatherController.class, tags = "getMarineWeather")
    @RequestMapping(value = "/MarineWeather/{city}", method = RequestMethod.GET)
    public MarineWeather getMarineWeather(@PathVariable String city) {
        MarineWeather marineWeather = new MarineWeather(3,"belle", "non significative", "ensoleillé", "bonne");
        return marineWeather;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
