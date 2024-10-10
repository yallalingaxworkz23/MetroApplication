package com.xworkz.metroApplication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.metroApplication.dto.UserLoginDTO;
import com.xworkz.metroApplication.entity.UserEntity;
import com.xworkz.metroApplication.entity.UserLoginEntity;
import com.xworkz.metroApplication.repository.UserLoginRepo;
import com.xworkz.metroApplication.repository.UserRegisterRepo;
import com.xworkz.metroApplication.services.UserLoginService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class UserLoginController {

	@Autowired
	private UserLoginRepo userLoginRepo;

	@Autowired
	private UserLoginService userLoginService;
	
	@Autowired
	private UserRegisterRepo userRegisterRepo;

	public UserLoginController() {
		log.info("invoking in the UserLoginController...");
	}

	@PostMapping("userLogin")
	public String onSaveLogin(UserLoginDTO userLoginDTO, Model model,HttpServletRequest httpServletRequest) {
		HttpSession httpSession= httpServletRequest.getSession(true);
	//	httpSession.setAttribute("email", userLoginDTO.getEmailid());
		if (userLoginService.onSave(userLoginDTO)) {
			
			UserEntity userEntity= userRegisterRepo.onEmailid(userLoginDTO.getEmailid());
			if(userEntity.isAccountblocked()==false) {
				model.addAttribute("username", userLoginDTO.getEmailid());
				return "profile";
			}else {
				model.addAttribute("lock", "account locked reset the password");
				return "login";
					
			}
		}
		model.addAttribute("username", userLoginDTO.getEmailid());
		model.addAttribute("perror", "password is incorrect.");
		return "login";
	}

	@PostMapping("/otpLogin")
	public String onOTPLogin(String emailid, String otp, Model model) {
		String forotp = userLoginService.onOtpLogin(emailid, otp);
		if (forotp == "") {
			model.addAttribute("email", emailid);
			return "passwordReset";
		}
		model.addAttribute("message", forotp);
		return "changePassword";
	}

	@PostMapping("/onresetpassword")
	public String onResetPassword(String emailid, String password, String conformpassword, Model model) {

		if (userLoginService.onResetPassword(emailid, password, conformpassword)) {
			return "Index";
		}
		model.addAttribute("passerror", "password is not updated..");
		return "passwordReset";

	}
}
