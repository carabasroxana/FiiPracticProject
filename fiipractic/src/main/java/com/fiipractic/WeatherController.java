package com.fiipractic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("weather")
public class WeatherController {
    @Autowired
    public SendRequestToWeatherService localVariable;
    @GetMapping(value = "details", produces = MediaType.APPLICATION_JSON_VALUE)
    public String fromDetails(@ModelAttribute Coordinates coordinates) {
        return localVariable.requestWeather(coordinates);


    }

}
