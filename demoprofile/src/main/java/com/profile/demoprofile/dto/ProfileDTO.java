package com.profile.demoprofile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {
	private String firstName;
	private String lastName;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String zipCode;
}
