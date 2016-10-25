package com.realdolmen.course.domain;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("VerfPersD")
public class VerifiedPerson extends Person{
	private Date verificationDate;
	private Long verificationId;
	//@Size(min = 13, max = 13)
	private Long creditcard;
	
	protected VerifiedPerson() {
		
	}
	
	public VerifiedPerson(String firstName, String lastName, String email, String password) {
		super(firstName, lastName, email, password);
	}
	
	public VerifiedPerson(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	public VerifiedPerson(String firstName, String lastName, Date verificationDate, Long verificationId, Long creditcard) {
		super(firstName, lastName);
		this.verificationDate = verificationDate;
		this.verificationId = verificationId;
		this.creditcard = creditcard;
	}
}
