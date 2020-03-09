package com.rms.service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rms.model.Mail;

@Service
public class MailService {
	
	@Autowired
	Mail mail;

	public static final Logger LOGGER = LogManager.getLogger();

	public void sendMail(String recieverMail) {
		// Create a Properties object to contain connection configuration information.
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", mail.getPORT());
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");

		// Create a Session object to represent a mail session with the specified
		// properties.
		Session session = Session.getDefaultInstance(props);
		
		try {
			
		
			// Create a message with the specified information.
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(mail.getFROM(),mail.getFROMNAME()));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recieverMail));
			msg.setSubject(mail.getSUBJECT());
			msg.setContent(mail.getBODY(), "text/html");

			// Create a transport.
			Transport transport = session.getTransport();

			// Send the message.
			try {
				LOGGER.info("Sending...");


				// Connect to Amazon SES using the SMTP username and password you specified
				// above.
				transport.connect(mail.getHOST(), mail.getSMTPUSERNAME(), mail.getSMTPPASSWORD());

				// Send the email.
				transport.sendMessage(msg, msg.getAllRecipients());
				LOGGER.info("Mail sent!");

			} catch (Exception ex) {
				LOGGER.error("The Mail was not sent.");
				LOGGER.error(ex.getMessage());
			} finally {
				// Close and terminate the connection.
				transport.close();
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}
}