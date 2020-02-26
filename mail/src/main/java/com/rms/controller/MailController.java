package com.rms.controller;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins =  "*")
public class MailController {
	// @Autowired
    // MailService ms;
    
	// @Autowired
    // UsersService us;
    
	// @RequestMapping(method = RequestMethod.POST, value = "/forgotpass.app", consumes = "application/json")
	// public @ResponseBody void sendEmail(@RequestBody Users user) {
	// 	String email = user.getEmail();
	// 	Users u = us.getByEmail(email);
	// 	String mail = u.getEmail();
	// 	try {
	// 		ms.sendEmail(mail);
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}
    // }
    
	// @RequestMapping(method = RequestMethod.POST, value = "/createaccount.app", consumes = "application/json") 
    //     public @ResponseBody void sendEmail(@RequestBody Users user) {
    //         String email = user.getEmail();
    //         Users u = us.getByEmail(email);
    //         String mail = u.getEmail();
    //         try {
    //             ms.sendEmail(mail);
    //         } catch (Exception e) {
    //             e.printStackTrace();
    //         }
    // }

}