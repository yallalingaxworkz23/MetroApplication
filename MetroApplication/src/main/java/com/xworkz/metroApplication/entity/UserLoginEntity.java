package com.xworkz.metroApplication.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="userlogin")
@NamedQuery(name="findbyEmailid",query = "Select emi from UserLoginEntity emi where emi.emailid=:em")
public class UserLoginEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="u_id")
	private Integer id;
	
	@Column(name="u_emailid")
	private String emailid;
	
	@Column(name="u_password")
	private String password;
	
	@Column(name="u_logindate")
	private LocalDate logindate;
	
	@Column(name="u_logintime")
	private LocalTime logintime;
	
	@Column(name="u_logouttime")
	private LocalTime logouttime;
	
	
	
	


}
