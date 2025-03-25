package com.ednue.weather;

import java.util.*;
import java.io.*;

abstract class WeatherData {
    protected HashMap<String, Double> cityTemperatures = new HashMap<>();
    protected LinkedList<String> historicalData = new LinkedList<>();
    protected HashSet<String> uniqueCities = new HashSet<>();

    public abstract void addCityWeather(String city, double temperature);
    public abstract double getCityWeather(String city) throws Exception;
    public abstract void viewWeatherHistory(String city);
    public abstract void sortCitiesByTemperature(boolean ascending);
    public abstract void saveWeatherData();
    public abstract void loadWeatherData();
    public abstract void autoUpdateWeather();
}