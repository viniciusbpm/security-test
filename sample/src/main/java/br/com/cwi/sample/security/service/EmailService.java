package br.com.cwi.sample.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarEmail(String emailAReceber, String assunto, String corpo){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(emailAReceber);
        message.setSubject(assunto);
        message.setText(corpo);

        javaMailSender.send(message);
    }
}
