package climalert.services;

import climalert.models.entities.Alerta;

public interface MailService {
  void enviarAlerta(Alerta alerta);
}
