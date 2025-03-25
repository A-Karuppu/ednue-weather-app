package com.ednue.weather;

import java.util.*;

abstract class AbstractWeatherData {
     HashMap<String, Double> cityTemperatures = new HashMap<>();
     LinkedList<String> historicalData = new LinkedList<>();
     HashSet<String> uniqueCities = new HashSet<>();

     abstract void addCityWeather(String city, double temperature);
     abstract double getCityWeather(String city) throws Exception;
     abstract void viewWeatherHistory(String city);
     abstract void sortCitiesByTemperature(boolean ascending);
     abstract void saveWeatherData();
     abstract void loadWeatherData();
     abstract void autoUpdateWeather();
}