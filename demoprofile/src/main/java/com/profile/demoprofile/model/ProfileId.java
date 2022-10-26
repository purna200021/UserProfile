package com.profile.demoprofile.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileId implements Serializable {
	private String firstName;
	private String lastName;
	
}
