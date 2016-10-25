package com.realdolmen.course.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.realdolmen.course.enums.AGECATEGORY;
import com.realdolmen.course.enums.INTERESSE;

@Entity //om statistieken te kunnen maken
public class Profile {
	@Id
	@GeneratedValue
	private Long id;
	private AGECATEGORY age;
	private INTERESSE interesse;
	
	protected Profile() {
		
	}
	public Profile(AGECATEGORY age, INTERESSE interesse) {
		this.age = age;
		this.interesse = interesse;
	}
	public AGECATEGORY getAge() {
		return age;
	}
	public void setAge(AGECATEGORY age) {
		this.age = age;
	}
	public INTERESSE getInteresse() {
		return interesse;
	}
	public void setInteresse(INTERESSE interesse) {
		this.interesse = interesse;
	}
	public Long getId() {
		return id;
	}
	
	//FamilyThree
}
