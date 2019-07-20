package pl.sda;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.model.Weather;

import java.io.File;
import java.io.IOException;

public class JsonDataFaster extends AbstractJsonData {

    @Override
    Weather getWeather() {
        ObjectMapper objectMapper = new ObjectMapper();
        Weather weather = null;
        try {
            weather = objectMapper.readValue(this.getJSONData("Torun"),
                    Weather.class);
            objectMapper.writeValue(new File("data.json"), weather);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return weather;
    }
}
