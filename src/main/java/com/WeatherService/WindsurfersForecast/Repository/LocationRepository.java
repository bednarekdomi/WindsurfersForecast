package com.WeatherService.WindsurfersForecast.Repository;

import com.WeatherService.WindsurfersForecast.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
