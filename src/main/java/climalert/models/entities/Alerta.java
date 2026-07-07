package climalert.models.entities;

import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Alerta {
  private Clima clima;
  private LocalDateTime fechaYhora;
}
