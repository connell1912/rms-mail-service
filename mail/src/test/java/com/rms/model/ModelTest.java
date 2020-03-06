package com.rms.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelTest {

	
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
    	assertEquals(System.getenv("SMTP_USERNAME"), m.getSMTP_USERNAME());
    }
    
    @Test
    public void testGetSMTP_PASSWORD() {
    	assertEquals(System.getenv("SMTP_PASSWORD"), m.getSMTP_PASSWORD());
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
