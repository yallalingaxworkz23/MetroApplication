package com.xworkz.metroApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.metroApplication.dto.UserDTO;
import com.xworkz.metroApplication.entity.UserEntity;
import com.xworkz.metroApplication.entity.UserLoginEntity;
import com.xworkz.metroApplication.repository.UserLoginRepo;
import com.xworkz.metroApplication.repository.UserRegisterRepo;


@Service
public class UserValidationServiceImpl implements UserValidationService{
	
	@Autowired
	private  UserRegisterRepo userRepo;
	
	@Autowired
	private UserLoginRepo userLoginRepo;
	
	

	@Override
	public String forEamilid(String emailid) {
	 UserEntity userentity= userRepo.onEmailid(emailid);
		 if(userentity!=null && userentity.getEmailid().equals(emailid)) {
			 return "";
		 }else {
		      return "user doesn't exist please register.";
		 }
	
	}
	
}
