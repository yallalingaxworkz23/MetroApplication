package com.xworkz.metroApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name="userRegister")
@Getter
@Setter
@NamedQuery(name="findUserByEmailid" ,query = "Select em from UserEntity em where em.emailid=:emid")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="u_id")
	private Integer id;
	
	@Column(name="u_firstName")
	private String firstname;
	
	@Column(name="u_lastName")
	private String lastname;
	
	@Column(name="u_emailid")
	private String emailid;
	
	@Column(name="u_contactno")
	private Long contactno;
	
	@Column(name="u_gender")
	private String gender;
	
	@Column(name="u_dateOfBirth")
	private String dateOfBirth;
	
	@Column(name="u_address")
	private String address;
	
	@Column(name="u_state")
	private String state;
	
	@Column(name="u_pincode")
	private Integer pincode;
	
	@Column(name="u_password")
	private String password;
	
	@Column(name="u_conformpassword")
	private String conformpassword;
	
	@Column(name="u_noofattemtpt")
	private Integer noAttemtpt;

	@Column(name="u_otp")
	private String otp;
	@Column(name="u_accountblocked")
	private boolean accountblocked;
}
