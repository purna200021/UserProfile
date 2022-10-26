/**
 * 
 */
package com.profile.demoprofile.controller;

import java.awt.color.ProfileDataException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.profile.demoprofile.dao.DemoProfileRepository;
import com.profile.demoprofile.dto.ProfileDTO;
import com.profile.demoprofile.model.Profile;
import com.profile.demoprofile.service.DemoProfileService;

/**
 * @author abc
 *
 */
@RestController
public class DemoProfileController {

	@Autowired
	private DemoProfileService service;

	@PostMapping("/addProfile")
	public String addProfile(@RequestBody ProfileDTO profileDto) {
		return service.addProfile(profileDto);

	}

	@GetMapping("/getAllProfiles")
	public List<Profile> findAll() {
		return service.findAll();
	}

	@GetMapping("/getProfilesById/{firstName}/{lastName}")
	public Profile findByBookId(@PathVariable String firstName, @PathVariable String lastName) {
		return service.findByKeyId(firstName, lastName);

	}


	@PutMapping("/updateProfile")
	public void updateProfiles(@RequestBody ProfileDTO profileDto) {
		service.updateProfiles(profileDto);

	}
	
	@PutMapping("/updateProfile/{firstName}/{lastName}")
	public Profile updateProfile(@RequestBody ProfileDTO profileDto, @PathVariable String firstName,
			@PathVariable String lastName) {
		return service.updateProfile(profileDto, firstName, lastName);

	}

	@DeleteMapping("/deleteAllProfiles")
	public String  delete() {
		service.deleteAllData();
		return "Delete Complete";
	}

}
