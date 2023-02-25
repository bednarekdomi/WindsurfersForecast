package com.WeatherService.WindsurfersForecast;

import com.WeatherService.WindsurfersForecast.dto.Cities;
import com.WeatherService.WindsurfersForecast.dto.ForecastDto;
import com.WeatherService.WindsurfersForecast.dto.Location;
import com.WeatherService.WindsurfersForecast.service.LocationService;
import com.WeatherService.WindsurfersForecast.service.WeatherClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.time.LocalDate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WindsurfersForecastApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(WindsurfersForecastApplication.class, args);

		WeatherClient weatherClient = new WeatherClient();
		Location forecastDto = weatherClient.getDataForLocation(Cities.BRIDGERTOWN);
		System.out.println(forecastDto);

	}
}
