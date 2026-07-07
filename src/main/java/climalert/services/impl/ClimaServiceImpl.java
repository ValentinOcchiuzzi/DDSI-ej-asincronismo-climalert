package climalert.services.impl;

import climalert.client.ClimaAdapter;
import climalert.models.entities.Clima;
import climalert.models.repositories.ClimaRepository;
import climalert.services.ClimaService;
import org.springframework.stereotype.Service;

@Service
public class ClimaServiceImpl implements ClimaService {
  private final ClimaAdapter climaAdapter;
  private final ClimaRepository climaRepository;

  public ClimaServiceImpl(ClimaAdapter climaAdapter,ClimaRepository climaRepository){
    this.climaAdapter = climaAdapter;
    this.climaRepository = climaRepository;
  }

  @Override
  public void almacenarClimaActual(){
    Clima clima = climaAdapter.obtenerClimaActual();
    climaRepository.save(clima);
    System.out.println("Clima almacenado");
  }

}
