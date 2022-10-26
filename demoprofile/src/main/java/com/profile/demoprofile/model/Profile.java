package com.profile.demoprofile.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.profile.demoprofile.model.ProfileId;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Profile {
	
	@EmbeddedId
	private ProfileId profileId;
	
	private String phone;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "profile")
	@JsonManagedReference
	private List<CustomerAddress> customerAddresses= new ArrayList();
	
	public void addAddress(CustomerAddress customerAddress){
		
		customerAddresses.add(customerAddress);
		customerAddress.setProfile(this);
    }
	


}