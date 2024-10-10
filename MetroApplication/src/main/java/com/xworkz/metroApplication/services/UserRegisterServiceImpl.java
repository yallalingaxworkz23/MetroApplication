package com.xworkz.metroApplication.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.metroApplication.dto.UserDTO;
import com.xworkz.metroApplication.entity.UserEntity;
import com.xworkz.metroApplication.repository.UserRegisterRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserRegisterServiceImpl implements UserRegisterService{
	
	@Autowired
	UserRegisterRepo userRepo;

	@Override
	public boolean onRigesterSave(UserDTO userDTO) {
		log.info("invoking in the onRigesterSave method..");
		UserEntity userEntity=new UserEntity();
		userDTO.setNoAttemtpt(0);
		userDTO.setAccountblocked(false);
		BeanUtils.copyProperties(userDTO, userEntity);
		 boolean tonknowsaved= userRepo.onSaveuser(userEntity);
		 log.info("to know the what value is return.."+tonknowsaved);
		 if(tonknowsaved==true) {
			 return true;
		 }
		return false;
	}

}
