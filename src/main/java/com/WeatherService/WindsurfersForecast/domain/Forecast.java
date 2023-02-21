package com.WeatherService.WindsurfersForecast.domain;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name="Forecasts")
public class Forecast {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    private LocalTime day;
    private double temperature;
    private double windSpeed;


}
