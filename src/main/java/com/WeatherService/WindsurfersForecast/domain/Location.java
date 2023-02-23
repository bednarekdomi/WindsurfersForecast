package com.WeatherService.WindsurfersForecast.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Location {
    private String name;
    private List<Forecast> forecastsForLocation;

    public boolean getForecastWithBestConditions() {
        forecastsForLocation.stream()
                .filter(forecast -> forecast.getAvrTemp() > 5 && forecast.getAvrTemp() < 35)
                .filter(f -> f.getWindSpd() > 5 && f.getWindSpd() < 18)
                .collect(Collectors.toList());
        if (forecastsForLocation.size() == 16) {
                    return true;
        }return false;
    }

    public List<Forecast> getForecastsForLocation() {
        return forecastsForLocation;
    }
}
