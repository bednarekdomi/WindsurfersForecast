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

}
