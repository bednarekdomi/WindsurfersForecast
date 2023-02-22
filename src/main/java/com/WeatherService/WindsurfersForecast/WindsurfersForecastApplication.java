package com.WeatherService.WindsurfersForecast;

import com.WeatherService.WindsurfersForecast.Service.LocationService;
import com.WeatherService.WindsurfersForecast.client.WeatherClient;
import com.WeatherService.WindsurfersForecast.domain.Forecast;
import com.WeatherService.WindsurfersForecast.domain.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WindsurfersForecastApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(WindsurfersForecastApplication.class, args);

		LocationService locationService = new LocationService();
		locationService.getLocationWithBestConditions(LocalDate.ofEpochDay(2023-02-22));

	}
}
