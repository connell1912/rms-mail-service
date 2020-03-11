package com.rms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.mail.MessagingException;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class MailServiceTest {

    private String to;

    @Mock
    private MailService testMailService;

    @BeforeAll
    public void testSmtpInit() {
        testMailService = new MailService();
        to = "mareshescoffery@gmail.com";
    }

    @Test
    public void testSendMail() throws InterruptedException, MessagingException {
        assertTrue(to.equals("mareshescoffery@gmail.com"));
        assertEquals(1, testMailService.sendMail(to));

    }
}
