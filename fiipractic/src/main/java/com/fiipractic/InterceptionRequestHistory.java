package com.fiipractic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class WeatherApiAspect {

    private final RequestHistoryService requestHistoryService;

    public WeatherApiAspect(RequestHistoryService requestHistoryService) {
        this.requestHistoryService = requestHistoryService;
    }

    @AfterReturning("execution(* com.fiipractic.service.WeatherService.callWeatherApi(..))")
    public void logWeatherApiCall(JoinPoint joinPoint) {
        RequestHistory history = new RequestHistory();
        history.setEndpointCalled("Weather API");
        history.setRequestTime(LocalDateTime.now().toString()); 
        requestHistoryService.saveRequestHistory(history);
    }
}
