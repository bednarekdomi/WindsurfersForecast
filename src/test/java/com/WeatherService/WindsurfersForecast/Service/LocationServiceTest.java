package com.WeatherService.WindsurfersForecast.Service;

import com.WeatherService.WindsurfersForecast.domain.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocationServiceTest {

    @Test
    void getLocationWithBestConditions() throws JsonProcessingException {
        //Given
        LocationService locationService = new LocationService();
        //When
        Location location = locationService.getLocationWithBestConditions(LocalDate.ofEpochDay(2023-02-23));
        //Then
        Assert.assertEquals("Bridgertown", location.getName());
    }
}