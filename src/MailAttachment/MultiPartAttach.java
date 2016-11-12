/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

    https://www.tutorialspoint.com/javamail_api/javamail_api_send_inlineimage_in_email.htm
 */
package MailAttachment;

/**
 *
 * @author hugo
 */

 /*
     MimeBodyPart attachPart = new MimeBodyPart();
     String attachFile = "D:/Documents/MyFile.mp4";
 
    DataSource source = new FileDataSource(attachFile);
   attachPart.setDataHandler(new DataHandler(source));
   attachPart.setFileName(new File(attachFile).getName());
 
     multipart.addBodyPart(attachPart);

  */


import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class MultiPartAttach 
{
  
    public static void main(String[] args) {
      // Recipient's email ID needs to be mentioned.
      String to = "hugo.ber.par@gmail.com";

      // Sender's email ID needs to be mentioned
      String from = "hugo.ber.par@gmail.com";
      final String username = "hugo.ber.par@gmail.com";//change accordingly
      final String password = "password";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "25");

      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
         });

      try {

         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject("Testing Subject");

         // This mail has 2 part, the BODY and the embedded image
         MimeMultipart multipart = new MimeMultipart("related");

         // first part (the html)
         BodyPart messageBodyPart = new MimeBodyPart();
         String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
         messageBodyPart.setContent(htmlText, "text/html");
         // add it
         multipart.addBodyPart(messageBodyPart);

         // second part (the image)
         messageBodyPart = new MimeBodyPart();
         DataSource fds = new FileDataSource(
            "/home/hugo/imagen1.jpeg");

         messageBodyPart.setDataHandler(new DataHandler(fds));
         messageBodyPart.setHeader("Content-ID", "<image>");

         // add image to the multipart
         multipart.addBodyPart(messageBodyPart);

         // put everything together
         message.setContent(multipart);
         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
    }
    
    
}
