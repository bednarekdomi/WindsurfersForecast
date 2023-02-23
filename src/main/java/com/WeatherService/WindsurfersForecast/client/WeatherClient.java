package com.WeatherService.WindsurfersForecast.client;

import com.WeatherService.WindsurfersForecast.domain.Forecast;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class WeatherClient {


    private RestTemplate restTemplate = new RestTemplate();

    public WeatherClient() throws JsonProcessingException {
    }

    private static final String API_KEY = "0ba7e66f8dfb4e528b936d9d36bc4740";
    private static final String API_URL = "https://api.weatherbit.io/v2.0/forecast/daily?city=";

    public List<Forecast> getForecast(String city) throws JsonProcessingException {

        String apiUrl = API_URL + city + "&key=" + API_KEY;

        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);

        List<Forecast> weatherDataList = new ArrayList<>();
        JsonNode dataNode = rootNode.get("data");
        if (dataNode.isArray()) {
            for (JsonNode jsonNode : dataNode) {
                Forecast weatherData = new Forecast();
                weatherData.setDatetime(LocalDate.parse(jsonNode.get("datetime").asText()));
                weatherData.setAvrTemp(jsonNode.get("temp").asDouble());
                weatherData.setWindSpd(jsonNode.get("wind_spd").asDouble());
                weatherDataList.add(weatherData);
            }
        }

        return weatherDataList;
    }

}


