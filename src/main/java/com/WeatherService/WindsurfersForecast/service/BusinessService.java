package com.WeatherService.WindsurfersForecast.service;

import com.WeatherService.WindsurfersForecast.dto.Cities;
import com.WeatherService.WindsurfersForecast.dto.ForecastDto;
import com.WeatherService.WindsurfersForecast.dto.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class BusinessService {
    private final static Map<Cities, Location> CITIES_OBJECT_MAP = new HashMap<>();
    private final static int MIN_TEMP = 5;
    private final static int MAX_TEMP = 35;
    private final static int MIN_WIND = 5;
    private final static int MAX_WIND = 18;
    private final WeatherClient weatherClient;

    public Location getBestCityByDate(LocalDate date) {
        Arrays.stream(Cities.values()).forEach(city -> {
            CITIES_OBJECT_MAP.put(city, weatherClient.getDataForLocation(city));
        });
        System.out.println(CITIES_OBJECT_MAP + "loooooooooooooooool");
        Map<Cities, ForecastDto> filteredLocations = new HashMap<>();
        CITIES_OBJECT_MAP.forEach((key, value) -> {
            Optional<ForecastDto> filteredForecast = value.getData().stream()
                    .filter(f->f.getDatetime() == date)
                    .filter(f -> f.getTemp() >= MIN_TEMP && f.getTemp() <= MAX_TEMP)
                    .filter(f->f.getWind_spd() >= MIN_WIND && f.getWind_spd() <= MAX_WIND)
                    .max(Comparator.comparingDouble(ForecastDto::getBestScore));
            filteredForecast.ifPresent(forecastDto -> filteredLocations.put(key, forecastDto));

        });


        return mapToResponseDto(filteredLocations);
    }

    private Location mapToResponseDto(Map<Cities, ForecastDto> filteredLocations) {
        Location location = new Location();
        List<ForecastDto> valueList = new ArrayList<>(filteredLocations.values());
        if (!filteredLocations.isEmpty()) {
            location.setCity_name(filteredLocations.keySet().iterator().next().toString());
        }
        location.setData(valueList);
        return location;
    }

}