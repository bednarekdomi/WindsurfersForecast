package com.WeatherService.WindsurfersForecast.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Location {
    private String city_name;
    private List<ForecastDto> data;

}
