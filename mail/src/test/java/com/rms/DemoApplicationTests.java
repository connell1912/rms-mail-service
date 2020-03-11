package com.rms;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.rms.model.Mail;
import com.rms.service.MailService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	Mail m = new Mail();
	MailService ms = new MailService();

	@Test
	void contextLoads() {

		assertTrue(587 == m.getPORT());

	}

}