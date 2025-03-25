package com.ednue.weather;

import java.util.Scanner;

public class MainMethodWeatherApp {
    public static void main(String[] args) {
        ImplementationOfWeather weatherTracker = new ImplementationOfWeather();
        Thread autoUpdateThread = new Thread(weatherTracker);
        autoUpdateThread.setDaemon(true);
        autoUpdateThread.start();

        Scanner scanner = new Scanner(System.in);

        weatherTracker.loadWeatherData();

        while (true) {
            System.out.println("\nWeather Tracker Menu:");
            System.out.println("1. Add city weather");
            System.out.println("2. View city temperature");
            System.out.println("3. View city weather history");
            System.out.println("4. Sort cities by temperature (Ascending)");
            System.out.println("5. Sort cities by temperature (Descending)");
            System.out.println("6. Save and Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter city name: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter temperature: ");
                    double temp = scanner.nextDouble();
                    weatherTracker.addCityWeather(city, temp);
                    break;
                case 2:
                    System.out.print("Enter city name: ");
                    city = scanner.nextLine();
                    try {
                        System.out.println("Temperature in " + city + ": " + weatherTracker.getCityWeather(city) + "°C");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter city name: ");
                    city = scanner.nextLine();
                    weatherTracker.viewWeatherHistory(city);
                    break;
                case 4:
                    weatherTracker.sortCitiesByTemperature(true);
                    break;
                case 5:
                    weatherTracker.sortCitiesByTemperature(false);
                    break;
                case 6:
                    weatherTracker.saveWeatherData();
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}