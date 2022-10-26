package com.profile.demoprofile.service;

import java.util.ArrayList;
import java.util.List;

import com.profile.demoprofile.dto.ProfileDTO;
import com.profile.demoprofile.model.Profile;

public interface DemoProfileService {
	List<Profile> findAll();

	Profile findByKeyId(String firstName, String lastName);

	String addProfile(ProfileDTO profiledto);

	void deleteAllData();

	Profile updateProfile(ProfileDTO profileDto, String firstName, String lastName);
	
	void updateProfiles(ProfileDTO profileDto);
}
