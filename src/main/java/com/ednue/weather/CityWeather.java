package com.ednue.weather;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class CityWeather extends WeatherData {

    public void addCityWeather(String city, double temperature) {
        cityTemperatures.put(city, temperature);
        historicalData.add(city + " - " + temperature);
        uniqueCities.add(city);
    }

    public double getCityWeather(String city) throws Exception {
        if (!cityTemperatures.containsKey(city)) {
            throw new Exception("City not found in records.");
        }
        return cityTemperatures.get(city);
    }

    public void sortCitiesByTemperature() {
        List<Map.Entry<String, Double>> sortedList = new ArrayList<>(cityTemperatures.entrySet());
        sortedList.sort(Map.Entry.comparingByValue());

        System.out.println("Cities sorted by temperature:");
        for (Map.Entry<String, Double> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "°C");
        }
    }

    public void saveWeatherData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("weather.txt"))) {
            for (String record : historicalData) {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("Weather data saved to weather.txt");
        } catch (IOException e) {
            System.out.println("Error saving weather data: " + e.getMessage());
        }
    }
}

