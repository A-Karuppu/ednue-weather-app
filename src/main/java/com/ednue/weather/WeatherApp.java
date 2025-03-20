package com.ednue.weather;

public class WeatherApp {
    public static void main(String[] args) {
        CityWeather weatherTracker = new CityWeather();

        weatherTracker.addCityWeather("New York", 15.5);
        weatherTracker.addCityWeather("Los Angeles", 22.3);
        weatherTracker.addCityWeather("Chicago", 10.2);

        try {
            System.out.println("Temperature in Los Angeles: " + weatherTracker.getCityWeather("Los Angeles") + "°C");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        weatherTracker.sortCitiesByTemperature();
        weatherTracker.saveWeatherData();
    }
}

