package com.WeatherService.WindsurfersForecast.Service;

import com.WeatherService.WindsurfersForecast.Repository.LocationRepository;
import com.WeatherService.WindsurfersForecast.domain.Location;
import com.WeatherService.WindsurfersForecast.domain.LocationDto;
import com.WeatherService.WindsurfersForecast.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class LocationService {

    private LocationMapper locationMapper;
    private LocationRepository locationRepository;

    Location location;

    List<Location> locations;

    @Autowired
    public LocationService(LocationMapper locationMapper, LocationRepository locationRepository) {
        this.locationMapper = locationMapper;
        this.locationRepository = locationRepository;
    }



}
