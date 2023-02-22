package com.WeatherService.WindsurfersForecast;

import com.WeatherService.WindsurfersForecast.Service.LocationService;
import com.WeatherService.WindsurfersForecast.client.WeatherClient;
import com.WeatherService.WindsurfersForecast.domain.Forecast;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WindsurfersForecastApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(WindsurfersForecastApplication.class, args);

	}
}
