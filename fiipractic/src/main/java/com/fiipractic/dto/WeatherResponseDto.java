package com.fiipractic.dto;

public record WeatherResponseDto(
        String summary,
        double temperature
) { }
