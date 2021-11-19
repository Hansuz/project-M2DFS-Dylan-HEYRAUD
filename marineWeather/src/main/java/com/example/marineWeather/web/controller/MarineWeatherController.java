package com.example.marineWeather.web.controller;

import com.example.marineWeather.dao.MarineWeatherDao;
import com.example.marineWeather.model.MarineWeather;
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

import java.util.List;

@Api(value="Marine Weather controller")

@RestController
public class MarineWeatherController {

    @Autowired
    //RestTemplate restTemplate;
    private MarineWeatherDao marineWeatherDao;

    String city;

    @ApiOperation(value = "Get details for all marine weather in their port", response = MarineWeatherController.class, tags = "getMarineWeather")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/MarineWeather", method = RequestMethod.GET)
    public List<MarineWeather> listMarineWeather() {
        return marineWeatherDao.findAll();
    }

    @ApiOperation(value = "Get details for marine weather in their port by city", response = MarineWeatherController.class, tags = "getCityMarineWeather")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/CityMarineWeather/{city}")
    public MarineWeather displayCityMarineWeather(@PathVariable String city) {
        return marineWeatherDao.findByCity(city);
    }

    /*
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
     */
}
