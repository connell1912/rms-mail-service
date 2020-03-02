package com.rms.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class MailControllerTest {

    @InjectMocks
    MailController mc;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void sendMailTest() {
        
        assertNotNull(mc.sendEmail());
    }
}