package com.WeatherService.WindsurfersForecast.service;

import com.WeatherService.WindsurfersForecast.dto.Cities;
import com.WeatherService.WindsurfersForecast.dto.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WeatherClient {

    private static final String API_KEY = "0ba7e66f8dfb4e528b936d9d36bc4740";
    private final WebClient webClient = WebClient.builder().build();

    public Location getDataForLocation(Cities city) {
        String API_URL = "https://api.weatherbit.io/v2.0/forecast/daily?city=" + city + "&key=" + API_KEY;
        Location responseDto = webClient.get().uri(API_URL).retrieve().bodyToMono(Location.class).block();
        calculateBestValue(responseDto);
        log.info("Response for city: {} from api service:{}", city.toString(), responseDto);
        return responseDto;
    }

    private void calculateBestValue(Location location) {
        location.getForecastList().forEach(f -> {
            f.setBestScore(f.getWind_spd() * 3 + f.getTemp());
        });
    }
}

