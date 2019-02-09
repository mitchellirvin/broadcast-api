package com.lhd.broadcastapi.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

@Service
public class Mailer {

  public void send(String to, String notification) {
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class",
        "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    // TODO: create new gmail account named earlybirdnoreply
    Session session = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("broadcastnoreply@gmail.com","broadcastpassword");
          }
        });

    try {
      Message message = new MimeMessage(session);
      message.setRecipients(Message.RecipientType.TO,
          InternetAddress.parse(to));
      message.setSubject("A New Issue is Open!");
      message.setText(notification);

      Transport.send(message);

      System.out.println("Email sent to: " + to);

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }

}
