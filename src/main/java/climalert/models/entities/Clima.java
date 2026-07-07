package climalert.models.entities;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Clima {
  private Double temperatura;
  private Double humedad;
  private LocalDateTime fechaYhora;
}
