package com.realdolmen.course.domain;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TweetTest {
	private ValidatorFactory factory;
	private Validator validator;
	
	@Before
	public void initValidatorinfrastructure(){
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
//	@Test
//	public void UsernameIsManditory() {
//		Tweet t = new Tweet(new Person("J", "J"), "I can see purple haze all around me", new Tag("Wazig"), new Tag("Paars"), new Tag("Whut"), new Tag("fop"));
//		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
//		assertEquals(1, violations.size());
//		ConstraintViolation<Tweet> error = violations.iterator().next();
//		assertEquals("size must be between 2 and 2147483647", error.getMessage());
//		System.out.println(violations);
//	}
	
	@After 
	public void destroyVlidatorInfrastructure() {
		factory.close();
	}
	
	@Test
	public void NoCussing() {
		Tweet t = new Tweet(new Person("Jimi", "J"), "I can see fucking purple", new Tag("Wazig"), new Tag("Paars"), new Tag("Whut"), new Tag("fop"));
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		assertEquals(1, violations.size());
		ConstraintViolation<Tweet> error = violations.iterator().next();
		assertEquals("Now now, don't fucking swear you bitch.", error.getMessage());
		System.out.println(violations);
	}
	
	

}
