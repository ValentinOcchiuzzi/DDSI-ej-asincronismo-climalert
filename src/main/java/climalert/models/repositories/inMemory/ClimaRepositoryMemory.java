package climalert.models.repositories.inMemory;

import climalert.models.entities.Clima;
import climalert.models.repositories.ClimaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ClimaRepositoryMemory implements ClimaRepository {
  private final List<Clima> registrosClimaticos = new ArrayList<>();

  @Override
  public void save(Clima clima){
    registrosClimaticos.add(clima);
  }

  @Override
  public Optional<Clima> ultimoRegistro(){
    if(registrosClimaticos.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(registrosClimaticos.get(registrosClimaticos.size()-1));
  }

  @Override
  public List<Clima> findAll(){
    return new ArrayList<>(registrosClimaticos);
  }
}
