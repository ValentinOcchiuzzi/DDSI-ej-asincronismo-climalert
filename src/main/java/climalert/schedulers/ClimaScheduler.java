package climalert.schedulers;

import climalert.services.ClimaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaScheduler {
  private final ClimaService almacenajeClimaService;

  public ClimaScheduler(ClimaService almacenajeClimaService){
    this.almacenajeClimaService = almacenajeClimaService;
  }

  @Scheduled(fixedRate = 300000)
  public void almacenarClima(){
    almacenajeClimaService.almacenarClimaActual();
  }
}
