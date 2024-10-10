package com.xworkz.metroApplication.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {

	@Id
	private Integer id;
	private String emailid;
	private String password;
	private LocalDate logindate;
	private LocalTime logintime;
	private LocalTime logouttime;
	
	

}
