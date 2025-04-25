package com.fiipractic;


import com.fiipractic.dto.WeatherResponseDto;
import jakarta.annotation.PreDestroy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@RestController
public class BatchWeatherController {

    private final SendRequestToWeatherService weatherService;
    private final ExecutorService executor = Executors.newFixedThreadPool(3);

    public BatchWeatherController(SendRequestToWeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/batch")
    public List<WeatherResponseDto> getBatchWeather() {
        List<Coordinates> locations = List.of(
                new Coordinates(40.7128, -74.0060),   // New York
                new Coordinates(51.5074,  -0.1278),   // London
                new Coordinates(35.6895, 139.6917)    // Tokyo
        );

        List<Future<WeatherResponseDto>> futures = locations.stream()
                .map(loc -> executor.submit(() -> weatherService.getWeather(loc)))
                .collect(Collectors.toList());

        return futures.stream()
                .map(f -> {
                    try {
                        return f.get();
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException("Lookup interrupted", ie);
                    } catch (ExecutionException ee) {
                        throw new RuntimeException("Lookup failed", ee.getCause());
                    }
                })
                .collect(Collectors.toList());
    }

    @PreDestroy
    public void cleanUp() {
        executor.shutdown();
    }
}
