package climalert.client;

import climalert.config.WeatherApiProperties;
import climalert.dto.CurrentWeatherResponse;
import climalert.dto.WeatherResponse;
import climalert.models.entities.Clima;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class WeatherApiClient implements ClimaAdapter {
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
  private final RestTemplate restTemplate;
  private final WeatherApiProperties properties;

  public WeatherApiClient(RestTemplate restTemplate, WeatherApiProperties properties) {
    this.restTemplate = restTemplate;
    this.properties = properties;
  }

  @Override
  public Clima obtenerClimaActual(){
    URI uri =
        UriComponentsBuilder.fromUriString(properties.getBaseUrl())
            .path("/current.json")
            .queryParam("key", properties.getApiKey())
            .queryParam("q", properties.getLocation())
            .build()
            .toUri();

    WeatherResponse response = restTemplate.getForObject(uri, WeatherResponse.class);

    CurrentWeatherResponse current = response.current();

    LocalDateTime fecha = LocalDateTime.parse(current.ultimaActualizacion(), FORMATTER);

    return new Clima(current.temperatura(), current.humedad(), fecha);
  }
}
