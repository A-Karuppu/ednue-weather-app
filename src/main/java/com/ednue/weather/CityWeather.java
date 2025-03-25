package com.ednue.weather;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class CityWeather extends WeatherData implements Runnable {

    public void addCityWeather(String city, double temperature) {
        cityTemperatures.put(city, temperature);
        historicalData.add(city + " - " + temperature + "°C");
        uniqueCities.add(city);
    }

    public double getCityWeather(String city) throws Exception {
        if (!cityTemperatures.containsKey(city)) {
            throw new Exception("City not found in records.");
        }
        return cityTemperatures.get(city);
    }

    public void viewWeatherHistory(String city) {
        System.out.println("Weather history for " + city + ":");
        for (String record : historicalData) {
            if (record.startsWith(city)) {
                System.out.println(record);
            }
        }
    }

    public void sortCitiesByTemperature(boolean ascending) {
        List<Map.Entry<String, Double>> sortedList = new ArrayList<>(cityTemperatures.entrySet());
        sortedList.sort(ascending ? Map.Entry.comparingByValue() : Map.Entry.comparingByValue(Comparator.reverseOrder()));

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

    public void loadWeatherData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("weather.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                historicalData.add(line);
            }
            System.out.println("Weather data loaded from weather.txt");
        } catch (IOException e) {
            System.out.println("Error loading weather data: " + e.getMessage());
        }
    }

    public void autoUpdateWeather() {
        for (String city : cityTemperatures.keySet()) {
            double newTemperature = ThreadLocalRandom.current().nextDouble(-10.0, 40.0);
            cityTemperatures.put(city, newTemperature);
            historicalData.add(city + " - " + newTemperature + "°C (Auto-updated)");
        }
        System.out.println("Weather auto-updated for all cities.");
        saveWeatherData();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1200000);
                autoUpdateWeather();
            } catch (InterruptedException e) {
                System.out.println("Weather update thread interrupted.");
                break;
            }
        }
    }
}