package climalert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WeatherResponse(
    @JsonProperty("current")
    CurrentWeatherResponse current
) {
}
