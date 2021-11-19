package com.example.marineWeather.dao;

import com.example.marineWeather.model.MarineWeather;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MarineWeatherDaoImpl implements MarineWeatherDao{

    public static List<MarineWeather>marineWeathers=new ArrayList<>();
    static {
        marineWeathers.add(new MarineWeather("bastia",3, "belle", "non significative", "ensoleillé","bonne"));
        marineWeathers.add(new MarineWeather("ile-rousse",3, "belle", "non significative", "beau temps","bonne"));
        marineWeathers.add(new MarineWeather("ajaccio",2, "belle", "non significative", "ensoleillé","bonne"));
    }

    @Override
    public List<MarineWeather>findAll() {
        return marineWeathers;
    }

    @Override
    public MarineWeather findByCity(String city) {
        for (MarineWeather marineWeather : marineWeathers) {
            if(marineWeather.getCity() == city){
                return marineWeather;
            }
        }
        return null;
    }

    @Override
    public MarineWeather save(MarineWeather marineWeather) {
        marineWeathers.add(marineWeather);
        return marineWeather;
    }

}
