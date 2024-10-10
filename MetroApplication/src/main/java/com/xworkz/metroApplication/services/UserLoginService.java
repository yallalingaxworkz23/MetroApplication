package com.xworkz.metroApplication.services;

import com.xworkz.metroApplication.dto.UserLoginDTO;

public interface UserLoginService {
	
	boolean onSave(UserLoginDTO userLoginDTO);
	
	public boolean sendmail(String mail,String subject,String body);
	
	String onEmailSent(String emailid);
	
	String onOtpLogin(String emailid,String otp);
	
	boolean onResetPassword(String emailid,String password,String conformpassword);

}
