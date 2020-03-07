package com.rms.service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rms.model.Mail;

@Service
public class MailService {
	
	@Autowired
	Mail mail;

	public void sendMail(String recieverMail) throws Exception {
		// Create a Properties object to contain connection configuration information.
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", mail.getPORT());
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");

		// Create a Session object to represent a mail session with the specified
		// properties.
		Session session = Session.getDefaultInstance(props);

		// Create a message with the specified information.
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(mail.getFROM(),mail.getFROMNAME()));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recieverMail));
		msg.setSubject(mail.getSUBJECT());
		msg.setContent(mail.getBODY(), "text/html");

		// Add a configuration set header. Comment or delete the
		// next line if you are not using a configuration set
//        msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);

		// Create a transport.
		Transport transport = session.getTransport();

		// Send the message.
		try {
			System.out.println("Sending...");//add advice


			// Connect to Amazon SES using the SMTP username and password you specified
			// above.
			transport.connect(mail.getHOST(), mail.getSMTP_USERNAME(), mail.getSMTP_PASSWORD());

			// Send the email.
			transport.sendMessage(msg, msg.getAllRecipients());
			System.out.println("Mail sent!");//add advice

		} catch (Exception ex) {//add advice
			System.out.println("The Mail was not sent.");
			System.out.println("Error message: " + ex.getMessage());
		} finally {
			// Close and terminate the connection.
			transport.close();
		}
	}
}