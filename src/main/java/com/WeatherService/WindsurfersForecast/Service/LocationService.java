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

    public Location getLocationWithBestConditions(LocalDate date) throws JsonProcessingException {
        List<Forecast> forecastForJastarnia = weatherClient.getForecast("Jastarnia");
        List<Forecast> forecastForBridgertown = weatherClient.getForecast("Bridgertown");
        List<Forecast> forecastForFortaleza = weatherClient.getForecast("Fortaleza");
        List<Forecast> forecastForPissouri = weatherClient.getForecast("Pissouri");
        List<Forecast> forecastsForLeMorne = weatherClient.getForecast("Le Morne");

        Location jastarnia = new Location("Jastarnia(Poland)", forecastForJastarnia);
        Location bridgertown = new Location("Bridgertown (Barbados)", forecastForBridgertown);
        Location fortaleza = new Location("Fortaleza(Brazil)", forecastForFortaleza);
        Location pissouri = new Location("Pissouri (Cyprus)", forecastForPissouri);
        Location leMorne = new Location("Le Morne (Mauritius)", forecastsForLeMorne);

        List<Location> locations = new ArrayList<>();
        locations.add(jastarnia);
        locations.add(bridgertown);
        locations.add(fortaleza);
        locations.add(pissouri);
        locations.add(leMorne);

        Location bestLocation = null;
        double bestScore = Double.NEGATIVE_INFINITY;

        List<Location> filteredLocations = new ArrayList<>();
        for (Location location : locations) {
            boolean isGoodLocation = true;
            for (Forecast forecast : location.getForecastsForLocation()) {
                if (forecast.getWindSpd() > 5 || forecast.getWindSpd() < 18 ||
                        forecast.getAvrTemp() > 5 || forecast.getAvrTemp() < 35) {
                    isGoodLocation = true;
//                    break;
                }
            }
            if (isGoodLocation) {
                filteredLocations.add(location);
            }
        }

        if (filteredLocations.size() == 1) {
            return filteredLocations.get(0);

        } else {
            for (Location location : filteredLocations) {
                double locationScore = 0;
                for (Forecast forecast : location.getForecastsForLocation()) {

                    locationScore = 0;
                    locationScore = forecast.getWindSpd() * 3 + forecast.getAvrTemp();
                }

                if (locationScore > bestScore) {
                    bestScore = locationScore;
                    bestLocation = location;
                }
            }
            System.out.println(bestLocation);
            return bestLocation;

        }

    }
}