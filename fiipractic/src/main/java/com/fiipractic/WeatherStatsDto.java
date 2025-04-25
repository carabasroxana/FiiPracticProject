package com.fiipractic;

public record WeatherStatsDto(
        double avgTemperature,
        double minTemperature,
        double maxTemperature,
        double avgWindSpeed,
        double avgHumidity
) { }
