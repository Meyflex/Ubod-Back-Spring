package com.ubod.springboot.security.dto;

import com.ubod.springboot.model.Objective;
import com.ubod.springboot.model.UserActivityLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class RegistrationRequest {

	@Email(message = "{registration_email_is_not_valid}")
	@NotEmpty(message = "{registration_email_not_empty}")
	private String email;

	@NotEmpty(message = "{registration_username_not_empty}")
	private String username;

	@NotEmpty(message = "{registration_password_not_empty}")
	private String password;

	// Additional fields for registration with validations
	@NotNull(message = "{registration_objective_not_empty}")
	private Objective objective;

	@NotEmpty(message = "{registration_weight_not_empty}")
	private String weight;

	@NotEmpty(message = "{registration_weightObj_not_empty}")
	private String weightObj;

	@NotEmpty(message = "{registration_height_not_empty}")
	private String height;

	@NotEmpty(message = "{registration_zipCode_not_empty}")
	private String zipCode;

	@NotEmpty(message = "{registration_address_not_empty}")
	private String address;

	@NotNull(message = "{registration_dateBirth_not_empty}")
	private Date dateBirth;

	@NotNull(message = "{registration_activityLevel_not_empty}")
	private UserActivityLevel activityLevel;

	@NotEmpty(message = "{registration_gender_not_empty}")
	private String gender;

}
