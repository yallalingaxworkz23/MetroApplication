package com.xworkz.metroApplication.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private Integer id;
	
	@NotNull
	@NotEmpty
	@Size(min = 4,max = 50,message = "fname must be 4 to 50")
	private String firstname;
	
	@NotNull
	@NotEmpty
	@Size(min = 1,max = 50,message = "lname must be 1 to 50")
	private String lastname;
	
	@NotEmpty
	@NotNull
	@Email
	private String emailid;
	
	@NotEmpty
	@NotNull
	@Size(message = "must be 10")
	private Long contactno;
	
	@NotEmpty
	@NotNull
	private String gender;
	
	@NotNull
	@NotEmpty
	private String dateOfBirth;
	
	@NotNull
	@NotEmpty
	@Size(min = 5, max = 200,message = "must be 5 to 200")
	private String address;
	
	@NotEmpty
	@NotNull
	@Size(min = 3,max = 20,message = "must be 3 to 20")
	private String state;
	
	@NotEmpty
	@NotNull
	@Size(min = 6,max = 6, message = "must be 6")
	private Integer pincode;
	
	@NotNull
	@NotEmpty
	@Size(min = 5,max = 25,message = "must be 5 to 25")
	private String password;
	
	@NotNull
	@NotEmpty
	@Size(min = 5,max = 25,message = "must be match")
	private String conformpassword;

	private Integer noAttemtpt;
	
	private String otp;
	private boolean accountblocked;
}
