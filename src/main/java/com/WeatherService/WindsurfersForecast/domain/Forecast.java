package com.WeatherService.WindsurfersForecast.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Forecast {

    private LocalDate datetime;
    private Double avrTemp;
    private Double windSpd;

}
