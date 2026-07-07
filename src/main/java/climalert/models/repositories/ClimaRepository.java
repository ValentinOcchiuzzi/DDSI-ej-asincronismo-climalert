package climalert.models.repositories;

import climalert.models.entities.Clima;
import java.util.List;
import java.util.Optional;

public interface ClimaRepository {
  void save(Clima clima);
  Optional<Clima> ultimoRegistro();
  List<Clima> findAll();
}
