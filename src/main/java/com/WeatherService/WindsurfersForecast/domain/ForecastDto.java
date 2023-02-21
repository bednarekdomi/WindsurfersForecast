package com.WeatherService.WindsurfersForecast.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalTime;

public class ForecastDto {

    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    private LocalTime day;
    private double temperature;
    private double windSpeed;
}
