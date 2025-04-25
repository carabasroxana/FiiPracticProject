package com.fiipractic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

public class RequestHistoryRepo {

    public double findAvgTemperature(double lat, double lon, Instant since) {
        return lat;
    }

    public double findMinTemperature(double lat, double lon, Instant since) {
        return lat;
    }

    public double findMaxTemperature(double lat, double lon, Instant since) {
        return lat;
    }

    public double findAvgWindSpeed(double lat, double lon, Instant since) {
        return lat;
    }

    public double findAvgHumidity(double lat, double lon, Instant since) {
        return lat;
    }

    @Repository
    public interface RequestHistoryRepository extends JpaRepository < RequestHistoryEntity, Long> {
    }

}
