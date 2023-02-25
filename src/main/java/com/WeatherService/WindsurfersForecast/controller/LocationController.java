package com.WeatherService.WindsurfersForecast.controller;

import com.WeatherService.WindsurfersForecast.dto.ForecastDto;
import com.WeatherService.WindsurfersForecast.dto.Location;
import com.WeatherService.WindsurfersForecast.service.BusinessService;
import com.WeatherService.WindsurfersForecast.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/WeatherApp")
public class LocationController {

    @Autowired
    private BusinessService businessService;

    @GetMapping(value = "/getLocationWithBestConditions")
    public Location getLocationWithBestConditions(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return businessService.getBestCityByDate(date);
    }
}

