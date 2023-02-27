package com.WeatherService.WindsurfersForecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WindsurfersForecastApplication {

	public static void main(String[] args) {
		SpringApplication.run(WindsurfersForecastApplication.class, args);
	}
}
