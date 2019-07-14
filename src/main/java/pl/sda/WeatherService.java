package pl.sda;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import pl.sda.model.Current;

import java.io.IOException;
import java.lang.String;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {
    private String url;
    private String apiKey;
    private String finalURL;

    public WeatherService(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
        this.finalURL = this.url + "?key=" + apiKey + "&q=";
    }

    public Current getCityWeather(String city) {

        this.finalURL = this.finalURL + city;
        System.out.println(this.finalURL);

        try {
            String data = IOUtils.toString(new URL(this.finalURL),
                    Charset.forName("UTF-8"));
            JSONObject jsonObject = new JSONObject(data);

            String temp = jsonObject.getJSONObject("current").get("temp_c").toString();
            String cloud = jsonObject.getJSONObject("current").get("cloud").toString();
            String pressure = jsonObject.getJSONObject("current").get("pressure_mb").toString();
            String humidity = jsonObject.getJSONObject("current").get("humidity").toString();
            String wind_kph = jsonObject.getJSONObject("current").get("wind_kph").toString();
            String wind_dir = jsonObject.getJSONObject("current").get("wind_dir").toString();
            String precip_in = jsonObject.getJSONObject("current").get("precip_in").toString();

            System.out.println(temp);
            System.out.println(cloud);
            System.out.println(pressure);
            System.out.println(humidity);
            System.out.println(wind_kph);
            System.out.println(wind_dir);
            System.out.println(precip_in);

            Current current = new Current();

            current.setTemp_c(Double.parseDouble(temp));
            current.setCloud(Double.parseDouble(cloud));
            current.setPressure_mb(Double.parseDouble(pressure));
            current.setHumidity(Double.parseDouble(humidity));
            current.setWind(Double.parseDouble(wind_kph));
            current.setPrecip_in(Double.parseDouble(precip_in));

            return current;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
