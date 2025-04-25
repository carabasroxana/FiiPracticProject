package com.fiipractic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class InterceptionRequestHistory {

    private RequestHistoryService requestHistoryService;

    public void WeatherApiAspect(RequestHistoryService requestHistoryService) {
        this.requestHistoryService = requestHistoryService;
    }

    @AfterReturning("execution(* com.fiipractic.service.WeatherService.callWeatherApi(..))")
    public void logWeatherApiCall(JoinPoint joinPoint) {
        RequestHistoryEntity history = new RequestHistoryEntity();
        history.setEndpointCalled("Weather API");
        history.setRequestTime(LocalDateTime.parse(LocalDateTime.now().toString()));
        requestHistoryService.saveRequestHistory(history);
    }
}
