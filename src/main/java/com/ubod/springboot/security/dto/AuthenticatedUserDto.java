package com.ubod.springboot.security.dto;

import com.ubod.springboot.model.Objective;
import com.ubod.springboot.model.UserActivityLevel;
import com.ubod.springboot.model.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserDto {


	private Long id; // To represent the unique ID

	private String username;

	private String password;

	private String email;

	private UserRole userRole;

	// Additional fields from User entity
	private Objective objective;
	private String weight;
	private String weightObj;
	private String height;
	private String zipCode;
	private String address;
	private Date dateBirth;
	private UserActivityLevel activityLevel;
	private String gender;
}


