package com.example.marineWeather.dao;

import com.example.marineWeather.model.MarineWeather;

import java.util.List;

public interface MarineWeatherDao {

    public List<MarineWeather> findAll();

    public MarineWeather findByCity(String city);

    public MarineWeather save(MarineWeather marineWeather);

}
