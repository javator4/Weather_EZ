package pl.sda;

import lombok.Data;
import org.apache.commons.io.IOUtils;
import pl.sda.model.Weather;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
@Data

public abstract class AbstractJsonData {

    private String url;
    private String apiKey;
    private String finalURL;
    private String data = "";

    public AbstractJsonData() {
        this.finalURL = this.url + "?key=" + apiKey + "&q=";
    }

    public void build(){
        this.finalURL = this.url + "?key=" + apiKey + "&q=";
    }


    public String getJSONData(String city) {
        if (this.data.isEmpty()) {
            this.finalURL = this.finalURL + city;
            System.out.println("WYWOŁANIE");
            try {
                this.data = IOUtils.toString(new URL(this.finalURL),
                        Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    abstract Weather getWeather();  //metoda abstrakcyjna
}
