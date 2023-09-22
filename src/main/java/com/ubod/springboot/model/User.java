package com.ubod.springboot.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String username;

	private String password;

	@Column(unique = true)  // Set email to be unique
	private String email;

	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	@Enumerated(EnumType.STRING)
	private Objective objective;

	private String weight;
	private String weightObj;
	private String height;
	private String zipCode;
	private String address;
	private Date dateBirth;

	@Enumerated(EnumType.STRING)
	private UserActivityLevel activityLevel;

	private String gender;
}
