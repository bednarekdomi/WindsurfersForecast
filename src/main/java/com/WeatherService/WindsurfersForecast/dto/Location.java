package com.WeatherService.WindsurfersForecast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private String city_name;
    @JsonProperty("data")
    private List<ForecastDto> forecastList;

}
