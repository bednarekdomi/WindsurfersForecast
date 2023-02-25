package com.WeatherService.WindsurfersForecast.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDto {

    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate datetime;
    private double temp;
    private double wind_spd;

    private double bestScore;
}
