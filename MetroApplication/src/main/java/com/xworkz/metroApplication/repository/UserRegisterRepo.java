package com.xworkz.metroApplication.repository;

import com.xworkz.metroApplication.entity.UserEntity;

public interface UserRegisterRepo {
	
	 boolean onSaveuser(UserEntity userEntity);
	 
	 UserEntity onEmailid(String emailid);
	 
	 boolean onUpdate(UserEntity userEntity);

}
