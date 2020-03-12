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
import org.springframework.stereotype.Service;
import com.rms.model.Mail;

@Service
public class MailService {

	Mail mail = new Mail();

	public static final Logger LOGGER = LogManager.getLogger();

	/**
	*   @author 1912dec16 Java Fullstack Batch 
	*   
	*    The sendMail method takes in a string argument. That string argument is for
	*     the email address that will sent to the requester.
	*    Once this method is invoked, it sets up the the properties of the configuration 
	*     to establish an SMTP connection. Then uses the Mail model to set up the messeage 
	*     to be sent. Afterwhich the SES username and password is given to  send the email
	*     programmatically. 
	* 
	*/
	public int sendMail(String recieverMail) throws MessagingException, UnsupportedEncodingException {
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
	}
}
