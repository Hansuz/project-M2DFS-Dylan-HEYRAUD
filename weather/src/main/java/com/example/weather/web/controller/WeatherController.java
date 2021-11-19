package com.example.weather.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class WeatherController {

    @Autowired
    RestTemplate restTemplate;

    @ApiOperation(value = "Get details for weather", response = WeatherController.class, tags = "getWeather")
    @RequestMapping(value = "/Weather/{key}", method = RequestMethod.GET)
    public String getWeather(@PathVariable String key) {
        String response = restTemplate.exchange("http://dataservice.accuweather.com/currentconditions/v1/{key}?apikey=1S8eDxJkj8iHWAaf3XbuMAhGQMgQOEpS&language=fr-fr",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, key).getBody();
        return response;
    }

    String city;

    @ApiOperation(value = "Get details for city", response = WeatherController.class, tags = "getCity")
    @RequestMapping(value = "/City/{city}", method = RequestMethod.GET)
    public String getCity(@PathVariable String city) {
        String response = restTemplate.exchange("http://dataservice.accuweather.com/locations/v1/cities/search?apikey=1S8eDxJkj8iHWAaf3XbuMAhGQMgQOEpS&q=" + city + "&language=fr-fr",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, city).getBody();
        return response;
    }

    @ApiOperation(value = "Get weather by city", response = WeatherController.class, tags = "getCityWeather")
    @RequestMapping(value = "/CityWeather/{city}", method = RequestMethod.GET)
    public String getCityWeather(@PathVariable String city) {
        String infocity = restTemplate.exchange("http://dataservice.accuweather.com/locations/v1/cities/search?apikey=1S8eDxJkj8iHWAaf3XbuMAhGQMgQOEpS&q=" + city + "&language=fr-fr",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, city).getBody();

        String json = infocity;
        System.out.println(json);
        json = json.substring(1, json.length() - 1);
        System.out.println(json);
        Map jsonJavaRootObject = new Gson().fromJson(json, Map.class);
        System.out.println(jsonJavaRootObject.get("Key"));

        String result = (String) jsonJavaRootObject.get("Key");

        String response = restTemplate.exchange("http://dataservice.accuweather.com/currentconditions/v1/" + result + "?apikey=1S8eDxJkj8iHWAaf3XbuMAhGQMgQOEpS&language=fr-fr",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, result).getBody();

        return response;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
