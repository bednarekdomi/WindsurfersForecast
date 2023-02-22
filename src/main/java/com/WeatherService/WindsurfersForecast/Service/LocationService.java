package com.WeatherService.WindsurfersForecast.Service;

import com.WeatherService.WindsurfersForecast.client.WeatherClient;
import com.WeatherService.WindsurfersForecast.domain.Forecast;
import com.WeatherService.WindsurfersForecast.domain.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Data
public class LocationService {

    private WeatherClient weatherClient = new WeatherClient();

    public LocationService() throws JsonProcessingException {
    }

    public void getLocationWithBestConditions(LocalDate date) throws JsonProcessingException {
        List<Forecast> forecastForJastarnia = weatherClient.getForecast("Jastarnia");
        List<Forecast> forecastForBridgertown = weatherClient.getForecast("Bridgertown");
        List<Forecast> forecastForFortaleza = weatherClient.getForecast("Fortaleza");
        List<Forecast> forecastForPissouri = weatherClient.getForecast("Pissouri");
        List<Forecast> forecastsForLeMorne = weatherClient.getForecast("Le Morne");

        Location jastarnia = new Location("Jastarnia", forecastForJastarnia);
        Location bridgertown = new Location("Bridgertown", forecastForBridgertown);
        Location fortaleza = new Location("Fortaleza", forecastForFortaleza);
        Location pissouri = new Location("Pissouri", forecastForPissouri);
        Location leMorne = new Location("Le Morne", forecastsForLeMorne);

        List<Location> forecastForLocations = new ArrayList<>();
        forecastForLocations.add(jastarnia);
        forecastForLocations.add(bridgertown);
        forecastForLocations.add(fortaleza);
        forecastForLocations.add(pissouri);
        forecastForLocations.add(leMorne);

        forecastForLocations.stream()
                .flatMap(location -> location.getForecastsForLocation().stream())
                .filter(forecast -> forecast.getAvrTemp() > 5 && forecast.getAvrTemp() < 35)
                .filter(f -> f.getWindSpd() > 5 && f.getWindSpd() < 18)
                .forEach(System.out::println);

        if (forecastForLocations.size() > 1){

        }
    }
}


