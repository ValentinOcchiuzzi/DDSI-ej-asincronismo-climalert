package climalert.services.impl;

import climalert.models.entities.Alerta;
import climalert.services.MailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
  private final JavaMailSender mailSender;

  public MailServiceImpl(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  @Override
  public void enviarAlerta(Alerta alerta){
    SimpleMailMessage mensaje = new SimpleMailMessage();

    mensaje.setTo("admin@clima.com", "emergencias@clima.com", "meteorologia@clima.com");
    mensaje.setSubject("Alerta Climática");
    mensaje.setText(
        "Se detectó una condición climática crítica.\n\n" +
            "Temperatura: " + alerta.getClima().getTemperatura() + " °C\n" +
            "Humedad: " + alerta.getClima().getHumedad() + " %\n" +
            "Fecha del clima: " + alerta.getClima().getFechaYhora() + "\n" +
            "Fecha de la alerta: " + alerta.getFechaYhora()
    );

    System.out.println("Enviando mail...");
    mailSender.send(mensaje);
  }

}
