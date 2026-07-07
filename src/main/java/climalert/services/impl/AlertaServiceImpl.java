package climalert.services.impl;

import climalert.models.entities.Alerta;
import climalert.models.entities.Clima;
import climalert.models.repositories.ClimaRepository;
import climalert.services.AlertaService;
import climalert.services.MailService;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AlertaServiceImpl implements AlertaService {
  private final ClimaRepository climaRepository;
  private final MailService mailService;

  public AlertaServiceImpl(ClimaRepository climaRepository, MailService mailService) {
    this.climaRepository = climaRepository;
    this.mailService = mailService;
  }

  @Override
  public void verificarAlerta(){
    Optional<Clima> ultimoRegistro = climaRepository.ultimoRegistro();
    if (ultimoRegistro.isEmpty()) {
      return;
    }
    Clima clima = ultimoRegistro.get();

    System.out.println("Verificando si hay alerta...");
    if(clima.getTemperatura() > 35 && clima.getHumedad() > 60){
      Alerta alerta = new Alerta(clima, LocalDateTime.now());
      mailService.enviarAlerta(alerta);
    }
  }
}
