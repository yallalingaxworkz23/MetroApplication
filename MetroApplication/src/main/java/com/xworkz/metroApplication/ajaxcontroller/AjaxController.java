package com.xworkz.metroApplication.ajaxcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.metroApplication.services.UserLoginService;
import com.xworkz.metroApplication.services.UserRegisterService;
import com.xworkz.metroApplication.services.UserValidationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class AjaxController {
	
	@Autowired
	private UserLoginService userLoginService;

	@Autowired
	private UserValidationService userValidationService;

	public AjaxController() {
		log.info("invoking in the ajaxController..");
	}
	///onemail/"+emails

	@GetMapping(value = "/uniqueEmail/{emailid}")
	public String onemailidexist(@PathVariable("emailid") String emailid) {
		log.info("invoking in the onemailidexist..method.. "+emailid);
		return userValidationService.forEamilid(emailid);
//		String foremail = 
//		if (foremail != null) {
//                  log.info("emialid is founded..");
//                  return foremail;
//		}
//
//		return null;
	}
	
	
	@GetMapping(value ="/otpgenerate/{emailid}")
	public String onOtpgenerate(@PathVariable String emailid) {
		log.info("invoking in the otpgenetate method.."+emailid);
		return userLoginService.onEmailSent(emailid);
	}
	

}
