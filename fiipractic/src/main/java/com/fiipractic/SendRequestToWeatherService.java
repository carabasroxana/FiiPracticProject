package com.fiipractic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class SendRequestToWeatherService {
    @Value("${api.key}")
    private String apiKey;
    public String requestWeather(Coordinates coordinates) {
        RestClient restClient = RestClient.create();
        String result = restClient.get()
                .uri("https://api.weatherapi.com/v1/current.json",builder -> builder
                        .queryParam("key",apiKey)
                        .queryParam("q", coordinates)
                        .build()
                )
                .retrieve()
                .body(String.class);
        return result;

    }
}
