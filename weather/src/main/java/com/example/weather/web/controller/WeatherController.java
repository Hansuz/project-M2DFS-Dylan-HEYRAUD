package com.example.weather.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    /*
    @ApiOperation(value = "Get weather for city", response = WeatherController.class, tags = "getWeatherCity")
    @RequestMapping(value = "/WeatherCity/{city}", method = RequestMethod.GET)
    public String getWeatherCity(@PathVariable String city) throws JSONException, JsonProcessingException {
        String jsonString = restTemplate.exchange("http://dataservice.accuweather.com/locations/v1/cities/search?apikey=1S8eDxJkj8iHWAaf3XbuMAhGQMgQOEpS&q=" + city + "&language=fr-fr",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, city).getBody();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonString);
        String response = jsonNode.asText();

        //Integer key = Integer.parseInt(obj.getString("Key"));

        //String response = obj.getJSONObject("").getString("Key");
        //String response = restTemplate.exchange("http://dataservice.accuweather.com/currentconditions/v1/{key}?apikey=1S8eDxJkj8iHWAaf3XbuMAhGQMgQOEpS&language=fr-fr",
        //        HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, key).getBody();
        return response;
    }
    */

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
