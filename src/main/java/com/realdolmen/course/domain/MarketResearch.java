package com.realdolmen.course.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


public class MarketResearch {
	@PersistenceContext
	private EntityManager em;
	
	public MarketResearch() {
	}
	
	MarketResearch(EntityManager em) {	
		this.em = em;
	}
	
	
	
	public List<Tweet> getAllTweets() {		
		//em.getTransaction().begin();
		TypedQuery<Tweet> query = em.createQuery("SELECT t FROM Tweet t", Tweet.class);
		List<Tweet> tweets = query.getResultList();

		//em.getTransaction().commit();
		return tweets;
	}
	
	public Double avgNumTagsPerTweet() {
		TypedQuery<Double> query = em.createQuery("select avg(t.tags.size) FROM Tweet t", Double.class);
		return query.getSingleResult();
	}
}
