package com.realdolmen.course.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("RegPers")
public class RegularPerson extends Person{
	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "profile_fk")
	private Profile profile;
	
	protected RegularPerson() {
		super();		
	}
	
	public RegularPerson(String firstName, String lastName, String email, String password) {
		super(firstName, lastName, email, password);		
	}
	
	public RegularPerson(String firstName, String lastName, String email, String password, Profile profile) {
		super(firstName, lastName, email, password);		
		this.profile = profile;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	

}
