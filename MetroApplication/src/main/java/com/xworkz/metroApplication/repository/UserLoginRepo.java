package com.xworkz.metroApplication.repository;

import com.xworkz.metroApplication.entity.UserLoginEntity;

public interface UserLoginRepo {
	
	boolean onSave(UserLoginEntity userLoginEntity);
	
	UserLoginEntity findByEmailid(String emailid);
	
	boolean onUpdate(UserLoginEntity userLoginEntity);

}
