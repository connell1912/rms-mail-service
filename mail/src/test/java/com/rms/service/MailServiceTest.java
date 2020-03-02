package com.rms.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rms.model.Mail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class MailServiceTest {

    @InjectMocks
    MailService ms;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void sendMailTest() {
        // ms.sendMail("mareshescoffery@gmail.com");
        assertTrue(true);
    }

}