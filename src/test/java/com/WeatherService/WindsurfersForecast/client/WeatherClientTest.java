package com.WeatherService.WindsurfersForecast.client;

import com.WeatherService.WindsurfersForecast.domain.Forecast;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherClientTest {


    @Test
    void getForecast() throws JsonProcessingException {
        //Given
        WeatherClient weatherClient = new WeatherClient();
        //When
        List<Forecast> testForecastList =  weatherClient.getForecast("Jastarnia");
        //Then
        Assert.assertEquals(16, testForecastList.size());
    }
}