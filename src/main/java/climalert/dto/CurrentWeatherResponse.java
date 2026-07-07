package climalert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CurrentWeatherResponse(
    @JsonProperty("temp_c")
    Double temperatura,

    @JsonProperty("humidity")
    Double humedad,

    @JsonProperty("last_updated")
    String ultimaActualizacion
) {
}
