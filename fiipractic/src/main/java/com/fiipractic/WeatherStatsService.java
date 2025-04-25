package com.fiipractic;


import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class WeatherStatsService {

    private final RequestHistoryRepo repo;

    public WeatherStatsService(RequestHistoryRepo repo) {
        this.repo = repo;
    }

    public WeatherStatsDto computeStats(double lat, double lon, Duration window) {
        Instant since = Instant.now().minus(window);
        double avgTemp = repo.findAvgTemperature(lat, lon, since);
        double minTemp = repo.findMinTemperature(lat, lon, since);
        double maxTemp = repo.findMaxTemperature(lat, lon, since);
        double avgWind = repo.findAvgWindSpeed(lat, lon, since);
        double avgHumidity = repo.findAvgHumidity(lat, lon, since);

        return new WeatherStatsDto(avgTemp, minTemp, maxTemp, avgWind, avgHumidity);
    }
}
