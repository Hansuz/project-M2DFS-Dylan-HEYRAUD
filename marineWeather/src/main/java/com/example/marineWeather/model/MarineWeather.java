package com.example.marineWeather.model;

public class MarineWeather {

    private String City;
    private int WindForce;
    private String Sea;
    private String Swell;
    private String Weather;
    private String Visibility;

    public MarineWeather(String city, int windForce, String sea, String swell, String weather, String visibility) {
        City = city;
        WindForce = windForce;
        Sea = sea;
        Swell = swell;
        Weather = weather;
        Visibility = visibility;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getWindForce() {
        return WindForce;
    }

    public void setWindForce(int windForce) {
        WindForce = windForce;
    }

    public String getSea() {
        return Sea;
    }

    public void setSea(String sea) {
        Sea = sea;
    }

    public String getSwell() {
        return Swell;
    }

    public void setSwell(String swell) {
        Swell = swell;
    }

    public String getWeather() {
        return Weather;
    }

    public void setWeather(String weather) {
        Weather = weather;
    }

    public String getVisibility() {
        return Visibility;
    }

    public void setVisibility(String visibility) {
        Visibility = visibility;
    }

    @Override
    public String toString(){
        return "{"+
                "city=" + City +
                ", windForce=" + WindForce +
                ", Sea=" + Sea +
                ", Swell=" + Swell +
                ", Weather=" + Weather +
                ", Visibility=" + Visibility + '}';
    }
}
