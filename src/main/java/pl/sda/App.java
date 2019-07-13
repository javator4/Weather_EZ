package pl.sda;

import pl.sda.model.Current;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      //  http://api.apixu.com/v1/current.json
        // ?key=49b8f045a61844fd91a82234191307&q=Paris

        WeatherService weatherService = new WeatherService(
                "http://api.apixu.com/v1/current.json",
                "49b8f045a61844fd91a82234191307"
        );
        weatherService.getCityWeather("Torun");


        System.out.println( "Hello World!" );
    }
}
