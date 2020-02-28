package com.rms.controller;

import com.rms.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
// @CrossOrigin(origins =  "*")
public class MailController {
	@Autowired
    MailService ms;
    
	// @Autowired
    // UsersService us;
    /**
	 * sendEmail is the method that will be called that takes in a string.
	 * It will send a password recovery email to that string.
	 * The string needs to be checked against the db and confirm that 
	 * a user matches the email
	 */
	@PostMapping("/newpassword")
	public String sendEmail() {//@RequestBody Users user
		// String email = user.getEmail();
		// Users u = us.getByEmail(email);
		/**
		 * mail is a string that will take in a users email address
		 */
		String mail = "mareshescoffery@gmail.com";//u.getEmail();
		try {
			ms.sendMail(mail);
			return "Please Check Your Email";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failed, Please Send Another Request";
    }
    

}