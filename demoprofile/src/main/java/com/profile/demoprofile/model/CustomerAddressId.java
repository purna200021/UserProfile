/**
 * 
 */
package com.profile.demoprofile.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author abc
 *
 */
@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressId implements Serializable {
	private String country;
	private String zipCode;
}
