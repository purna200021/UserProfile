/**
 * 
 */
package com.profile.demoprofile.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profile.demoprofile.dao.DemoProfileRepository;
import com.profile.demoprofile.dto.ProfileDTO;
import com.profile.demoprofile.exception.ResourceNotFoundException;
import com.profile.demoprofile.model.CustomerAddress;
import com.profile.demoprofile.model.CustomerAddressId;
import com.profile.demoprofile.model.Profile;
import com.profile.demoprofile.model.ProfileId;

/**
 * @author abc
 *
 */
@Service
public class DemoProfileServiceImpl implements DemoProfileService {
//  @Service marks a Java class that performs some service,
//  such as executing business logic, performing 
//  calculations, and calling external APIs.


	@Autowired
	private DemoProfileRepository repository;

	@Override
	public List<Profile> findAll() {
		return repository.findAll();
	}

	@Override
	public String addProfile(ProfileDTO profiledto) {
		ProfileId profileId = ProfileId.builder().firstName(profiledto.getFirstName())
				.lastName(profiledto.getLastName()).build();

		Profile profile = Profile.builder().profileId(profileId).phone(profiledto.getPhone())
				.customerAddresses(new ArrayList<CustomerAddress>()).build();

		CustomerAddressId customerAddressId = CustomerAddressId.builder().country(profiledto.getFirstName())
				.zipCode(profiledto.getLastName()).build();

		CustomerAddress customerAddress = CustomerAddress.builder().addressLine1(profiledto.getAddressLine1())
				.addressLine2(profiledto.getAddressLine2()).city(profiledto.getCity()).state(profiledto.getState())
				.country(profiledto.getCountry()).zipCode(profiledto.getZipCode()).profile(profile).build();
		
		profile.addAddress(customerAddress);
		repository.save(profile);
		
		return "Profile saved..";

	}

	@Override
	public void deleteAllData() {
		repository.deleteAll();
	}

	@Override
	public Profile findByKeyId(String firstName, String lastName) {
		Profile profile = null;
		try {
			 profile = repository.findById(new ProfileId(firstName, lastName)).get();	
		} catch (Exception e) {
               throw new ResourceNotFoundException("Customer Profile not found ");
		}
		return profile;
	}
	
	@Override
	public void updateProfiles(ProfileDTO profileDto) {
		Profile profile =repository.findById(new ProfileId(profileDto.getFirstName(),profileDto.getLastName())).get();
		profile.setPhone(profileDto.getPhone());
	    repository.save(profile);
	}
	@Override
	public Profile updateProfile(ProfileDTO profileDto,String firstName, String lastName) {
		Profile  profile = findByKeyId(firstName, lastName);
		profile.setPhone(profileDto.getPhone());
		return repository.save(profile);
	}

}
