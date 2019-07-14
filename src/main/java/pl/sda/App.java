package pl.sda;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.model.Current;
import pl.sda.model.Location;
import pl.sda.model.Weather;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class App {
    public static void main(String[] args) {
        String url =
                "http://api.apixu.com/v1/current.json" +
                        "?key=49b8f045a61844fd91a82234191307&q=Paris";

        WeatherService weatherService = new WeatherService(
                "http://api.apixu.com/v1/current.json",
                "49b8f045a61844fd91a82234191307"
        );
        //  Current current = weatherService.getJSONData("Torun").getCityWeather();
        //Location location = weatherService.getJSONData("Torun").getLocation();

        // System.out.println("LAT: " + location.getLat());
        // System.out.println("LON: " + location.getLon());

        WeatherForecast weatherForecast = new OrgImplementation(weatherService, "Torun");
        WeatherForecast weatherForecast1 = new FasterImplementation(weatherService, "Torun");

        System.out.println(weatherForecast.getWeather());
    }
}

