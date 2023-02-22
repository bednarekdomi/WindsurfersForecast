package com.WeatherService.WindsurfersForecast.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    @JsonProperty("datetime")
    private LocalDate datetime;
    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("temp")
    private Double avrTemp;
    @JsonProperty("wind_spd")
    private Double windSpd;

}
