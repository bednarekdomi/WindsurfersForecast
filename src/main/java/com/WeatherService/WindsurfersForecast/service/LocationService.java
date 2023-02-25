package com.WeatherService.WindsurfersForecast.service;

import com.WeatherService.WindsurfersForecast.dto.ForecastDto;
import com.WeatherService.WindsurfersForecast.dto.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@Data
public class LocationService {
//
//    private WeatherClient weatherClient = new WeatherClient();
//
//    public LocationService() throws JsonProcessingException {
//    }
//
//    public List<Location> getLocations() {
//        List<ForecastDto> forecastDtoForJastarnia = weatherClient.getForecast("Jastarnia");
//        List<ForecastDto> forecastDtoForBridgertown = weatherClient.getForecast("Bridgertown");
//        List<ForecastDto> forecastDtoForFortaleza = weatherClient.getForecast("Fortaleza");
//        List<ForecastDto> forecastDtoForPissouri = weatherClient.getForecast("Pissouri");
//        List<ForecastDto> forecastsForLeMorne = weatherClient.getForecast("Le Morne");
//
//        Location jastarnia = new Location("Jastarnia(Poland)", forecastDtoForJastarnia);
//        Location bridgertown = new Location("Bridgertown (Barbados)", forecastDtoForBridgertown);
//        Location fortaleza = new Location("Fortaleza(Brazil)", forecastDtoForFortaleza);
//        Location pissouri = new Location("Pissouri (Cyprus)", forecastDtoForPissouri);
//        Location leMorne = new Location("Le Morne (Mauritius)", forecastsForLeMorne);
//
//        List<Location> locations = new ArrayList<>();
//        locations.add(jastarnia);
//        locations.add(bridgertown);
//        locations.add(fortaleza);
//        locations.add(pissouri);
//        locations.add(leMorne);
//
//        return locations;
//    }
//
//    public ForecastDto getBestLocationForTheDay(LocalDate date) {
//        List<Location> locations = getLocations();
//        List<ForecastDto> bestForecastsForTheDay = new ArrayList<>();
//        for (Location location : locations) {
//            List<ForecastDto> filteredForecastDto = location.filterForecasts();
//            for (ForecastDto forecastDto : filteredForecastDto) {
//                if (forecastDto.getDatetime() == date) {
//                    bestForecastsForTheDay.add(forecastDto);
//                }
//            }
//
//        }
//        if (bestForecastsForTheDay.size() > 1) {
//            for (ForecastDto forecastDto : bestForecastsForTheDay) {
//                ForecastDto bestForecastDto;
//                List<Double> scores = new ArrayList<>();
//                Double score = forecastDto.calculateValue();
//                scores.add(score);
//                Double maxScore = Collections.max(scores, null);
//                if(Objects.equals(forecastDto.calculateValue(), maxScore)){
//                    bestForecastDto = forecastDto;
//                    return bestForecastDto;
//                }
//            }
//        } else if (bestForecastsForTheDay.size() == 1) {
//            return bestForecastsForTheDay.get(0);
//        }
//        return null;
//    }
}

