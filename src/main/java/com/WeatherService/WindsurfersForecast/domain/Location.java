package com.WeatherService.WindsurfersForecast.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Locations")
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;
    private String name;
    private LocalDate today;
    private List <Double> temperaturesFor16Days;
    private List <Double> windFor16Days;

}
