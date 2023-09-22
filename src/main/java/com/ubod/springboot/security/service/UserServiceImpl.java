package com.ubod.springboot.security.service;

import com.ubod.springboot.service.UserValidationService;
import com.ubod.springboot.model.User;
import com.ubod.springboot.model.UserRole;
import com.ubod.springboot.security.dto.AuthenticatedUserDto;
import com.ubod.springboot.security.dto.RegistrationRequest;
import com.ubod.springboot.security.dto.RegistrationResponse;
import com.ubod.springboot.security.mapper.UserMapper;
import com.ubod.springboot.utils.GeneralMessageAccessor;
import com.ubod.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

	private final UserRepository userRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final UserValidationService userValidationService;

	private final GeneralMessageAccessor generalMessageAccessor;

	@Override
	public User findByIdentifier(String username) {
		User user  = userRepository.findByUsername(username);
		if (user == null ){
			user  = userRepository.findByEmail(username);
		}
		return user;
	}

	@Override
	public RegistrationResponse registration(RegistrationRequest registrationRequest) {

		userValidationService.validateUser(registrationRequest);

		final User user = UserMapper.INSTANCE.convertToUser(registrationRequest);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserRole(UserRole.USER);


		userRepository.save(user);

		final String username = registrationRequest.getUsername();
		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL, username);

		log.info("{} registered successfully!", username);

		return new RegistrationResponse(registrationSuccessMessage);
	}

	@Override
	public AuthenticatedUserDto findAuthenticatedUserByIdentifier(String username) {

		final User user = findByIdentifier(username);

		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(user);
	}
}
