package com.xworkz.metroApplication.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.xworkz.metroApplication.dto.UserDTO;
import com.xworkz.metroApplication.dto.UserLoginDTO;
import com.xworkz.metroApplication.entity.UserEntity;
import com.xworkz.metroApplication.entity.UserLoginEntity;
import com.xworkz.metroApplication.repository.UserLoginRepo;
import com.xworkz.metroApplication.repository.UserRegisterRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginRepo userLoginRepo;

	@Autowired
	private UserRegisterRepo userRegisterRepo;

	@Override
	public boolean onSave(UserLoginDTO userLoginDTO) {
		UserEntity userentity = userRegisterRepo.onEmailid(userLoginDTO.getEmailid());
		if(userentity!=null) {
			if(userentity.isAccountblocked()) {
				return true;
			}
			if (userentity != null && userentity.getNoAttemtpt() < 2 ) {
				
				if (userentity.getEmailid().equals(userLoginDTO.getEmailid())
				&& userentity.getPassword().equals(userLoginDTO.getPassword())) {
					userentity.setAccountblocked(false);
					userentity.setNoAttemtpt(0);
					userRegisterRepo.onUpdate(userentity);
					
					userLoginDTO.setLogindate(LocalDate.now());
					userLoginDTO.setLogintime(LocalTime.now());
					UserLoginEntity userLoginEntity = new UserLoginEntity();
					BeanUtils.copyProperties(userLoginDTO, userLoginEntity);
					return userLoginRepo.onSave(userLoginEntity);

				}
				if (userentity.getEmailid().equals(userLoginDTO.getEmailid())) {
					userentity.setNoAttemtpt(userentity.getNoAttemtpt() + 1);
					userRegisterRepo.onUpdate(userentity);
					return false;
				}
	         
			}
	          userentity.setAccountblocked(true);
	          userRegisterRepo.onUpdate(userentity);
	          sendmail(userentity.getEmailid(),"AC Lock", "You are Account is locked please reset the password");
			return false;

		}
		return false;
	}

	@Async
	@Override
	public boolean sendmail(String mail, String subject, String body) {

		String portNumber = "587";
		String hostName = "smtp.gmail.com";
		String fromEmail = "yallu3630@gmail.com";
		String password = "yokn fugk bexk mvcg";
		String to = mail;

		Properties prop = new Properties();

		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocol", "smtp");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject(subject);
			message.setText(body);

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			log.info("email sent successfully..");
//				vmanagementrepo.findByEmailid(fromEmail);
			return true;

		}

		catch (MessagingException e) {

			e.printStackTrace();
		}

		return false;
	}

	public String generateRandomPassword() {

		PasswordGenerator passGen = new PasswordGenerator();

		CharacterRule lcr = new CharacterRule(EnglishCharacterData.LowerCase);
		lcr.setNumberOfCharacters(2);

		CharacterRule dr = new CharacterRule(EnglishCharacterData.Digit);
		dr.setNumberOfCharacters(2);

		String randomPassword = passGen.generatePassword(8, lcr, dr);
		return randomPassword;

	}

	@Override
	public String onEmailSent(String emailid) {
		UserEntity userentity = userRegisterRepo.onEmailid(emailid);
		if (userentity != null && userentity.getEmailid().equals(emailid)) {
			String otp= generateRandomPassword();

			if (sendmail(emailid, "Change-Password", "otp for change password is.." +otp)) {
				log.info("otp id." + otp);
				userentity.setOtp(otp);
				if (userRegisterRepo.onUpdate(userentity)) {
					return "otp sent to mail";
				}
			}
			return "not sent";
		}
		return "plese do register.";
	}

	@Override
	public String onOtpLogin(String emailid, String otp) {
		UserEntity userEntity = userRegisterRepo.onEmailid(emailid);
		if (userEntity != null && userEntity.getEmailid().equals(emailid) && userEntity.getOtp().equals(otp)) {
			return "";
		}
		return "otp is missmatch";
	}

	@Override
	public boolean onResetPassword(String emailid, String password, String conformpassword) {
		UserEntity userEntity = userRegisterRepo.onEmailid(emailid);
		userEntity.setPassword(password);
		userEntity.setConformpassword(conformpassword);
		userEntity.setAccountblocked(false);
		userEntity.setNoAttemtpt(0);
		return userRegisterRepo.onUpdate(userEntity);
	}

}
