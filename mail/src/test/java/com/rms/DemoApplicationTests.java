package com.rms;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rms.model.Mail;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	Mail m;
	@Before
	void init(){
		m = new Mail();
	}

	@Test
	void contextLoads() {
		assertNotNull(new Mail("mareshescoffery@gmail.com"));
		assertNotNull(m.getBODY());
		assertNotNull(m.getFROM());
		assertNotNull(m.getFROMNAME());
		assertNotNull(m.getHOST());
		assertNotNull(m.getSMTPPASSWORD());
		assertNotNull(m.getSMTPUSERNAME());
		assertNotNull(m.getSUBJECT());
		assertTrue(587 == m.getPORT());

	}

}