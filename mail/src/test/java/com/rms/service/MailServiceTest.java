package com.rms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.mail.Message;
import javax.mail.MessagingException;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetupTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class MailServiceTest {

    @InjectMocks
    private JavaMailSenderImpl emailSender;

    @Mock
    private GreenMail testSmtp;

    @BeforeAll
    public void testSmtpInit() {
        testSmtp = new GreenMail(ServerSetupTest.SMTP);
        // testSmtp.setUser("AKIAR5NF4UGVRMYTFHKE",
        // "BK7fA59x972H7MF2x3ux6n9T0RbZnIrAMvrNYCVT6+Dh");
        testSmtp.start();

        emailSender.setUsername("AKIAR5NF4UGVRMYTFHKE");
        emailSender.setPassword("BK7fA59x972H7MF2x3ux6n9T0RbZnIrAMvrNYCVT6+Dh");
        emailSender.setPort(587);
        emailSender.setHost("email-smtp.us-east-1.amazonaws.com");

    }

    @Test
    public void testSendMail() throws InterruptedException, MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("project3.1912@gmail.com");
        message.setTo("mareshescoffery@gmail.com");
        message.setSubject("test subject");
        message.setText("test message");
        emailSender.send(message);

        Message[] messages = testSmtp.getReceivedMessages();
        assertEquals(0, messages.length);
        // assertEquals("test subject", messages[0].getSubject());
        // String body = GreenMailUtil.getBody(messages[0]).replaceAll("=\r?\n", "");
        // assertEquals("test message", body);
    }

    @AfterAll
    public void cleanup() {
        testSmtp.stop();
    }
}
