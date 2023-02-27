package com.WeatherService.WindsurfersForecast.controller;

import com.WeatherService.WindsurfersForecast.dto.Location;
import com.WeatherService.WindsurfersForecast.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/WeatherApp")
public class LocationController {

    private final WeatherService businessService;

    @GetMapping(value = "/getLocationWithBestConditions")
    public Location getLocationWithBestConditions(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return businessService.getBestCityByDate(date);
    }
}

