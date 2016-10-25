package com.realdolmen.course.domain;

import java.sql.Date;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.realdolmen.course.utilities.persistence.JpaPersistenceTest;

public class VerifiedPersonTest extends JpaPersistenceTest{
	@Test
	public void makingAndRetreivingPerson() throws Exception {
		VerifiedPerson  user = new VerifiedPerson("john", "doe", new Date(1980,05,18), 1548L, 1245784512457L);
		EntityManager em = entityManager();		
		em.persist(user);

		assertNotNull(em.find(VerifiedPerson.class, user.getId()));		
	}
}
