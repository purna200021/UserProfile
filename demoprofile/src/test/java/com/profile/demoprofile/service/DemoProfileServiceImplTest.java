package com.profile.demoprofile.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.profile.demoprofile.dao.DemoProfileRepository;
import com.profile.demoprofile.dto.ProfileDTO;
import com.profile.demoprofile.exception.ResourceNotFoundException;
import com.profile.demoprofile.model.CustomerAddress;
import com.profile.demoprofile.model.Profile;
import com.profile.demoprofile.model.ProfileId;

class DemoProfileServiceImplTest {

	@InjectMocks
	DemoProfileServiceImpl demoProfileServiceImpl;

	@Mock
	DemoProfileRepository demoProfileRepository;

	Profile profile;
	ProfileId profileId;

	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		profileId = new ProfileId();
		profileId.setFirstName("John");
		profileId.setLastName("NewBy");

		profile = new Profile();
		profile.setPhone("770-444-7777");
		profile.setProfileId(profileId);


		CustomerAddress customerAddress = new CustomerAddress();
		customerAddress.setAddressLine1("Test");
		customerAddress.setAddressLine2("Test1");
		customerAddress.setCity("Johnscreek");
		customerAddress.setCountry("USA");
		customerAddress.setState("GA");
		customerAddress.setZipCode("30047");
		customerAddress.setProfile(profile);


		List<CustomerAddress> customerAddresses = new ArrayList();
		customerAddresses.add(customerAddress);
	
	}

	@Test
	void testAddProfile() {
		ProfileDTO profileDTO = new ProfileDTO();
		profileDTO.setFirstName("Jeff");
		profileDTO.setLastName("Solan");
		profileDTO.setAddressLine1("1015 Post Road");
		profileDTO.setAddressLine2("");
		profileDTO.setCity("Cumming");
		profileDTO.setState("GA");
		profileDTO.setCountry("USA");
		profileDTO.setZipCode("30041");
		profileDTO.setPhone("770-333-4444");
		demoProfileServiceImpl.addProfile(profileDTO);
		assertNotNull(profileDTO);
		assertEquals("Jeff", profileDTO.getFirstName());
		assertEquals("Solan", profileDTO.getLastName());

	}

	@Test
	void testfindByKeyId() {
		when(demoProfileRepository.findById(profileId)).thenReturn(Optional.of(profile));
		Profile profile1 = demoProfileServiceImpl.findByKeyId("John", "NewBy");
		assertNotNull(profile1);
		assertEquals("770-444-7777", profile1.getPhone());

	}

	@Test
	void testGetUser_UsernameNotFoundException() {
		when(demoProfileRepository.findById(profileId)).thenReturn(null);
		assertThrows(ResourceNotFoundException.class, () -> {
			demoProfileServiceImpl.findByKeyId("John", "NewBy");
		});
	}

}
