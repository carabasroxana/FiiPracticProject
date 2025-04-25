package com.fiipractic;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.Duration;

@RestController
@RequestMapping("/weather/stats")
public class WeatherStatsController {

    private final WeatherStatsService stats;

    public WeatherStatsController(WeatherStatsService stats) {
        this.stats = stats;
    }

    @Operation(
            summary = "Compute weather statistics for a location",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Stats returned",
                            content = @Content(schema = @Schema(implementation = WeatherStatsDto.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized")
            }
    )
    @GetMapping
    public WeatherStatsDto getStats(
            @Parameter(description = "Latitude", example = "40.7")
            @RequestParam double lat,

            @Parameter(description = "Longitude", example = "-74.0")
            @RequestParam double lon,

            @Parameter(description = "ISO-8601 duration window", example = "PT24H")
            @RequestParam(defaultValue = "PT24H") Duration window
    ) {
        return stats.computeStats(lat, lon, window);
    }
}

