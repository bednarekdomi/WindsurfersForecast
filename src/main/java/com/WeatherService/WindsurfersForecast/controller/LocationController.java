package com.WeatherService.WindsurfersForecast.controller;

import com.WeatherService.WindsurfersForecast.Service.LocationService;
import com.WeatherService.WindsurfersForecast.domain.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/WeatherApp")
public class LocationController {

    private LocationService locationService;

    @GetMapping(name = "/getLocationWithBestConditions")
    public Location getLocationWithBestConditions(@RequestParam LocalDate date) throws JsonProcessingException {
        Location location = locationService.getLocationWithBestConditions(date);
        return location;
    }
}

