package com.example.weather.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Api(value="Weather controller")

@RestController
public class WeatherController {

    @Autowired
    RestTemplate restTemplate;

    @ApiOperation(value = "Get details for weather", response = WeatherController.class, tags = "getWeather")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/Weather/{key}", method = RequestMethod.GET)
    public String getWeather(@PathVariable String key) {
        String response = restTemplate.exchange("http://dataservice.accuweather.com/currentconditions/v1/{key}?apikey=1S8eDxJkj8iHWAaf3XbuMAhGQMgQOEpS&language=fr-fr",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, key).getBody();
        return response;
    }

    String city;

    @ApiOperation(value = "Get details for city", response = WeatherController.class, tags = "getCity")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/City/{city}", method = RequestMethod.GET)
    public String getCity(@PathVariable String city) {
        String response = restTemplate.exchange("http://dataservice.accuweather.com/locations/v1/cities/search?apikey=1S8eDxJkj8iHWAaf3XbuMAhGQMgQOEpS&q=" + city + "&language=fr-fr",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, city).getBody();
        return response;
    }

    @ApiOperation(value = "Get weather by city", response = WeatherController.class, tags = "getCityWeather")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
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

    @ApiOperation(value = "Get Forecast for weather for 1 days", response = WeatherController.class, tags = "getForecast1Days")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "Forecast1Days/{city}", method = RequestMethod.GET)
    public String getForecast1Days(@PathVariable String city)
    {
        String infocity = restTemplate.exchange("http://dataservice.accuweather.com/locations/v1/cities/search?apikey=1S8eDxJkj8iHWAaf3XbuMAhGQMgQOEpS&q=" + city + "&language=fr-fr",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, city).getBody();

        String json = infocity;
        System.out.println(json);
        json = json.substring(1, json.length() - 1);
        System.out.println(json);
        Map jsonJavaRootObject = new Gson().fromJson(json, Map.class);
        System.out.println(jsonJavaRootObject.get("Key"));

        String result = (String) jsonJavaRootObject.get("Key");

        String response = restTemplate.exchange("http://dataservice.accuweather.com/forecasts/v1/daily/1day/" + result + "?apikey=1S8eDxJkj8iHWAaf3XbuMAhGQMgQOEpS&language=fr-fr",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, result).getBody();
        return response;
    }

    @ApiOperation(value = "Get Forecast for weather for 5 days", response = WeatherController.class, tags = "getForecast5Days")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "Forecast5Days/{city}", method = RequestMethod.GET)
    public String getForecast5Days(@PathVariable String city)
    {
        String infocity = restTemplate.exchange("http://dataservice.accuweather.com/locations/v1/cities/search?apikey=1S8eDxJkj8iHWAaf3XbuMAhGQMgQOEpS&q=" + city + "&language=fr-fr",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, city).getBody();

        String json = infocity;
        System.out.println(json);
        json = json.substring(1, json.length() - 1);
        System.out.println(json);
        Map jsonJavaRootObject = new Gson().fromJson(json, Map.class);
        System.out.println(jsonJavaRootObject.get("Key"));

        String result = (String) jsonJavaRootObject.get("Key");

        String response = restTemplate.exchange("http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + result + "?apikey=1S8eDxJkj8iHWAaf3XbuMAhGQMgQOEpS&language=fr-fr",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, result).getBody();
        return response;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
