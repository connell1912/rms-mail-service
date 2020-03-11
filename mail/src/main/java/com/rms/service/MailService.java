package com.rms.service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
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

	public int sendMail(String recieverMail) {
		try {
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

		// Create a transport.
		Transport transport = session.getTransport();

		// Send the message.
	
		LOGGER.info("Sending...");

		// Connect to Amazon SES using the SMTP username and password you specified
		// above.
		transport.connect(mail.getHOST(), mail.getSMTPUSERNAME(), mail.getSMTPPASSWORD());

		// Send the email.
		transport.sendMessage(msg, msg.getAllRecipients());
		LOGGER.info("Mail sent!");

		// Close and terminate the connection.
		transport.close();
		return 1;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return -1;
		}
		
			
		 
	}
}