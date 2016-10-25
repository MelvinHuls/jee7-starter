package com.realdolmen.course.domain;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import com.realdolmen.course.utilities.persistence.JpaPersistenceTest;

public class QueryTests extends JpaPersistenceTest {
	@Before
	public void init() {
		EntityManager em = entityManager();
		Person person = new Person("bob", "joe");
		em.persist(person);
		Tag tag = new Tag("no");
		em.persist(tag);
		Tweet t = new Tweet(person, "oh god no", tag);				
		em.persist(t);
		
		tag = new Tag("lol");
		em.persist(tag);
		t = new Tweet(person, "let's hope this works", tag);
		em.persist(t);
	}
	
	
	@Test
	public void findAllTweets() {	
		EntityManager em = entityManager();
		MarketResearch research = new MarketResearch(em);
		
		assertEquals(2,research.getAllTweets().size());
	}
	
	@Test
	public void countAvgNumTagsTweets() {	
		EntityManager em = entityManager();
		MarketResearch research = new MarketResearch(em);
		
		assertEquals(1,research.avgNumTagsPerTweet(), 0.001);
	}
	
	

}
