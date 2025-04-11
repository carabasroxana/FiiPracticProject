package com.fiipractic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

public class Logging {
    @Slf4j
    @Service
        public String callWeatherApi() {
            log.info("Calling external Weather API...");
            return "Sunny";
        }
    }

