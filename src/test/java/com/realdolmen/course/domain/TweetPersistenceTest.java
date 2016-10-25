package com.realdolmen.course.domain;

import javax.persistence.EntityManager;

import org.hibernate.persister.walking.spi.EncapsulatedEntityIdentifierDefinition;
import org.junit.Assert;
import org.junit.Test;

import com.realdolmen.course.utilities.persistence.JpaPersistenceTest;

public class TweetPersistenceTest extends JpaPersistenceTest {
	/*@Test
	public void tweenCanBeRetreived() throws Exception {
		EntityManager em = entityManager();
		Tweet tweet = em.find(Tweet.class, 1000L);		
		assertEquals("I see purple haze", tweet.getMessage());
		assertEquals("Jimi", tweet.getUsername());
	}
	
	@Test
	public void tweetCanBePersisted() throws Exception {
		EntityManager em = entityManager();
		Tweet t  = new Tweet("Amy", "I need to go to rehab");
		em.persist(t);
		//assertNotNull(t.getId());
	}
	
	@Test
	public void dataCanBePersistedAndRetreived() throws Exception {
		EntityManager em = entityManager();
		Tweet t = new Tweet ("Jimi", "Hello world", "ACTIVE", "world", "hello", "printout");
		em.persist(t);	
		Tweet t2 = em.find(Tweet.class, t.getId());
		assertNotNull(t2);
		assertNotNull(t2.getDate());
	}*/
	
	
	@Test
	public void userCanBePersistedAndRetrieved() throws Exception {
		Person user = new Person("john", "doe", "john.doe@gmail.com", "*****");
		assertNotNull(user);
		EntityManager em = entityManager();
		
		em.persist(user);
		assertNotNull(em.find(Person.class, user.getId()));		
	}
	
	@Test
	public void tagCanBePersistedAndRetrieved() throws Exception {
		Tag tag = new Tag("lol");
		assertNotNull(tag);
		EntityManager em = entityManager();
		
		em.persist(tag);
		assertNotNull(em.find(Tag.class, tag.getId()));		
	}
	
	@Test
	public void tweetCanBePersistedAndRetrieved() throws Exception {
		Person user = new Person("john", "doe", "john.doe@gmail.com", "*****");
		Tweet tweet = new Tweet(user, "Omg what am I doing?", new Tag("lol"));
		assertNotNull(tweet);
		EntityManager em = entityManager();
		
		em.persist(user);
		em.persist(tweet);
		assertNotNull(em.find(Tweet.class, tweet.getId()));		
	}
	
	@Test
	public void dataPersistedTweetCanRetrieved() throws Exception {
		EntityManager em = entityManager();
		Person user = new Person("john", "doe", "john.doe@gmail.com", "*****");
		em.persist(user);
		Tag t = new Tag("lol");
		Tag t2 = new Tag("lol");		
		em.persist(t);
		Tweet tweet = new Tweet(user, "Omg what am I doing?", t, t2);
		em.persist(tweet);
		
		assertEquals("john",(em.find(Tweet.class, tweet.getId()).getUser().getFirstName()));
		assertEquals("lol",(em.find(Tweet.class, tweet.getId()).getTags().get(0).getName()));		
	}
	
}
