package com.WeatherService.WindsurfersForecast.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDto {

    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate datetime;
    private double temp;
    private double wind_spd;
    private double bestScore;
}
