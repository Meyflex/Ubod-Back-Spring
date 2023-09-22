package com.ubod.springboot.security.service;

import com.ubod.springboot.model.User;
import com.ubod.springboot.security.dto.AuthenticatedUserDto;
import com.ubod.springboot.security.dto.RegistrationRequest;
import com.ubod.springboot.security.dto.RegistrationResponse;

public interface UserService {

	User findByIdentifier(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByIdentifier(String username);

}
