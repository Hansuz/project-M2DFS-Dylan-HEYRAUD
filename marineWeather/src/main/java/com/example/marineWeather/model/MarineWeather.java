package com.example.marineWeather.model;

public class MarineWeather {

    private int windForce;
    private String Sea;
    private String Swell;
    private String Weather;
    private String Visibility;

    public MarineWeather(int windForce, String sea, String swell, String weather, String visibility) {
        this.windForce = windForce;
        Sea = sea;
        Swell = swell;
        Weather = weather;
        Visibility = visibility;
    }

    public int getWindForce() {
        return windForce;
    }

    public void setWindForce(int windForce) {
        this.windForce = windForce;
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
}
