package com.WeatherService.WindsurfersForecast.controller;

import com.WeatherService.WindsurfersForecast.Service.LocationService;
import com.WeatherService.WindsurfersForecast.domain.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/WeatherApp")
public class LocationController {

    private LocationService locationService;

    @GetMapping(name = "/getLocationWithBestConditions")
    public Location getLocationWithBestConditions(@PathVariable LocalDate date) throws JsonProcessingException {
        Location location = locationService.getLocationWithBestConditions(date);
        System.out.println(location);
        return location;
    }
}

