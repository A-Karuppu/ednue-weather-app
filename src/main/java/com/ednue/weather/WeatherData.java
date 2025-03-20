package com.ednue.weather;

import java.util.*;
import java.io.*;

abstract class WeatherData {
     HashMap<String, Double> cityTemperatures = new HashMap<>();
     List<String> historicalData = new ArrayList<>();
     HashSet<String> uniqueCities = new HashSet<>();

    public abstract void addCityWeather(String city, double temperature);
    public abstract double getCityWeather(String city) throws Exception;
    public abstract void sortCitiesByTemperature();
    public abstract void saveWeatherData();
}
