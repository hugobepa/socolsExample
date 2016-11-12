/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleEmail;

/**
 *  https://www.tutorialspoint.com/java/java_sending_email.htm
 * @author hugo
 */
// File Name SendEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

   public static void main(String [] args) {    
      final String username = "hugo.ber.par@gmail.com";
		final String password = "Antoni@77";
                //TLS
                /*
                 properties=new Properties();
                 properties.put("mail.smtp.host", host);
                 properties.put("mail.smtp.port", port);
                 properties.put("mail.smtp.starttls.enable", "true");
                 properties.put("mail.smtp.auth", "true");
                
                */
                
                
                //SSL
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("hugo.ber.par@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("hugo.ber.par@gmail.com"));
			message.setSubject("PRUEBA");
			message.setText("Dear Duck,"
				+ "\n\n No spam to my email, please!\nEsto es un prueba");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
   }
}
