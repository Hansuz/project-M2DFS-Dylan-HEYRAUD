package com.example.weather.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    @Autowired
    RestTemplate restTemplate;

    @ApiOperation(value = "Get details for school", response = WeatherController.class, tags = "getWeather")

    /*
    @RequestMapping(value="/Weather", method= RequestMethod.GET)
    public String listeWeather() {
        return "Un exemple de météo";
    }

    @GetMapping(value = "/Weather/{citiesNames}")
    public String seeWeather(@PathVariable int citiesNames) {
        return "Vous avez demandé la météo de la ville  " + citiesNames;
    }
     */

    @RequestMapping(value = "/Weather/{key}", method = RequestMethod.GET)
    public String getWeather(@PathVariable String key) {
        String response = restTemplate.exchange("http://dataservice.accuweather.com/currentconditions/v1/{key}?apikey=1S8eDxJkj8iHWAaf3XbuMAhGQMgQOEpS&language=fr-fr",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, key).getBody();
        return response;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
