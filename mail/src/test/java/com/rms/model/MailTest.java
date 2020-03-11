package com.rms.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailTest {

	
    private Mail m = new Mail();

    @Test
    public void testGetTo() {
    	m.setTo("you");
    	assertEquals("you", m.getTo());
    }
    
    @Test
    public void testGetFrom() {
    	assertEquals("project3.1912@gmail.com", m.getFROM());
    }
    
    @Test
    public void testGetFromNAME() {
    	assertEquals("Revature RMS", m.getFROMNAME());
    }
    
    @Test
    public void testGetSMTP_USERNAME() {
    	assertEquals(System.getenv("SMTP_USERNAME"), m.getSMTPUSERNAME());
    }
    
    @Test
    public void testGetSMTP_PASSWORD() {
    	assertEquals(System.getenv("SMTP_PASSWORD"), m.getSMTPPASSWORD());
    }
    
    @Test
    public void testGetHOST() {
    	assertEquals("email-smtp.us-east-1.amazonaws.com", m.getHOST());
    }
    
    @Test
    public void testGetPORT() {
    	assertEquals(587, m.getPORT());
    }
    
    @Test
    public void testGetSUBJECT() {
    	assertEquals("Password Reset", m.getSUBJECT());
    }
    
    @Test
    public void testGetBODY() {
    	assertEquals(String.join(System.getProperty("line.separator"), "<h1>Password Reset</h1>",
        "<p>Reset your password at ",
        "<a href='http://localhost:3000/passchange'>RMS Reset Password</a>"), m.getBODY());
    }
}
