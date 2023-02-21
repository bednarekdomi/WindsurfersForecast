package com.WeatherService.WindsurfersForecast.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class LocationDto {
    private Long id;
    private String name;
    private LocalDate today;
    private List<Double> temperaturesFor16Days;
    private List <Double> windFor16Days;
}
