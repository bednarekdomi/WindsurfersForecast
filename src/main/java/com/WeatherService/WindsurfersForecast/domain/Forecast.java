package com.WeatherService.WindsurfersForecast.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data

public class Forecast {

    private LocalDate datetime;
    private Double avrTemp;
    private Double windSpd;

    public Double getBestForecast(){
        Double result = windSpd * 3 + avrTemp;
        return result;
    }
}
