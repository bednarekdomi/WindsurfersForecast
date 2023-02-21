package com.WeatherService.WindsurfersForecast.mapper;

import com.WeatherService.WindsurfersForecast.domain.Location;
import com.WeatherService.WindsurfersForecast.domain.LocationDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationMapper {

    public Location mapToLocation(LocationDto locationDto){
        return new Location(locationDto.getId(), locationDto.getName(), locationDto.getForecasts());
    }

    public LocationDto mapToLocationDto(Location location){
        return new LocationDto(location.getId(), location.getName(), location.getForecasts());
    }

    public List<LocationDto> mapToLocationDtoList(List<Location>locationsList){
        return locationsList.stream().map(l -> new LocationDto(l.getId(), l.getName(), l.getForecasts()))
                .collect(Collectors.toList());
    }

}
