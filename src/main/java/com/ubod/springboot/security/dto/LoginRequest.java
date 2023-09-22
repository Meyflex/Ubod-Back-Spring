package com.ubod.springboot.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

	@NotEmpty(message = "{login_identifier_not_empty}")  // Renamed validation message
	private String identifier;  // Can be either username or email

	@NotEmpty(message = "{login_password_not_empty}")
	private String password;

}
