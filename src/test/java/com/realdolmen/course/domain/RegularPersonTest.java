package com.realdolmen.course.domain;

import javax.persistence.EntityManager;

import com.realdolmen.course.enums.AGECATEGORY;
import com.realdolmen.course.enums.INTERESSE;
import com.realdolmen.course.utilities.persistence.JpaPersistenceTest;

import org.junit.Test;

public class RegularPersonTest extends JpaPersistenceTest{
	
	@Test
	public void makingAndRetreivingPerson() throws Exception {
		RegularPerson  user = new RegularPerson("john", "doe", "john.doe@gmail.com", "*****");
		EntityManager em = entityManager();
		em.persist(user);

		assertNotNull(em.find(RegularPerson.class, user.getId()));		
	}
	
	@Test
	public void AddingAProfile() throws Exception {
		Profile profile = new Profile(AGECATEGORY.TwentyOneTo30, INTERESSE.MUSIEK);
		RegularPerson  user = new RegularPerson("john", "doe", "john.doe@gmail.com", "*****", profile);
		EntityManager em = entityManager();		
		em.persist(user);
		em.persist(profile);		

		RegularPerson p = em.find(RegularPerson.class, user.getId());
		assertNotNull(p);
		Profile pr = p.getProfile();
		assertNotNull(pr);
		assertEquals(INTERESSE.MUSIEK, pr.getInteresse());
	}
}
