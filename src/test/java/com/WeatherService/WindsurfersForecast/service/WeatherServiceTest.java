//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.WeatherService.WindsurfersForecast.dto.Cities;
//import com.WeatherService.WindsurfersForecast.dto.ForecastDto;
//import com.WeatherService.WindsurfersForecast.dto.Location;
//import com.WeatherService.WindsurfersForecast.service.WeatherClient;
//import com.WeatherService.WindsurfersForecast.service.WeatherService;
//
//public class WeatherServiceTest {
//
//    private static final LocalDate TEST_DATE = LocalDate.now();
//    private static final Cities TEST_CITY = Cities.AMSTERDAM;
//
//    private WeatherClient weatherClient;
//    private WeatherService weatherService;
//
//    @BeforeEach
//    public void setup() {
//        weatherClient = mock(WeatherClient.class);
//        weatherService = new WeatherService(weatherClient);
//    }
//
//    @Test
//    public void testGetBestCityByDate() {
//        // Mock the WeatherClient to return a forecast for the test city on the test date
//        ForecastDto testForecast = new ForecastDto();
//        testForecast.setCity(TEST_CITY);
//        testForecast.setDatetime(TEST_DATE);
//        testForecast.setTemp(20);
//        testForecast.setWind_spd(10);
//        when(weatherClient.getDataForLocation(TEST_CITY)).thenReturn(new Location(Collections.singletonList(testForecast)));
//
//        // Call the method being tested
//        Location result = weatherService.getBestCityByDate(TEST_DATE);
//
//        // Verify that the method returned the expected result
//        assertEquals(TEST_CITY.toString(), result.getCity_name());
//        assertEquals(1, result.getForecastList().size());
//        assertEquals(testForecast, result.getForecastList().get(0));
//    }
//
//    @Test
//    public void testGetBestCityByDate_noMatchingForecasts() {
//        // Mock the WeatherClient to return a forecast for the test city on the test date,
//        // but with temperatures and wind speeds outside the valid range
//        ForecastDto testForecast = new ForecastDto();
//        testForecast.setCity(TEST_CITY);
//        testForecast.setDatetime(TEST_DATE);
//        testForecast.setTemp(40);
//        testForecast.setWind_spd(20);
//        when(weatherClient.getDataForLocation(TEST_CITY)).thenReturn(new Location(Collections.singletonList(testForecast)));
//
//        // Call the method being tested
//        Location result = weatherService.getBestCityByDate(TEST_DATE);
//
//        // Verify that the method returned an empty Location object
//        assertEquals("", result.getCity_name());
//        assertEquals(0, result.getForecastList().size());
//    }
//
//    @Test
//    public void testGetBestCityByDate_noForecastsForAnyCity() {
//        // Mock the WeatherClient to return empty forecast lists for all cities
//        Map<Cities, Location> emptyLocationMap = new HashMap<>();
//        Arrays.stream(Cities.values()).forEach(city -> emptyLocationMap.put(city, new Location()));
//        when(weatherClient.getDataForLocation(TEST_CITY)).thenReturn(new Location());
//
//        // Call the method being tested
//        Location result = weatherService.getBestCityByDate(TEST_DATE);
//
//        // Verify that the method returned an empty Location object
//        assertEquals("", result.getCity_name());
//        assertEquals(0, result.getForecastList().size());
//    }
//}
