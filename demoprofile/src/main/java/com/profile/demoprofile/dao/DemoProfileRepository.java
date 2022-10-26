/**
 * 
 */
package com.profile.demoprofile.dao;


import com.profile.demoprofile.model.Profile;
import com.profile.demoprofile.model.ProfileId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author abc
 *
 */
@Repository 
public interface DemoProfileRepository extends  JpaRepository<Profile, ProfileId> {

}
