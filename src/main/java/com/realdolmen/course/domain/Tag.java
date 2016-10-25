package com.realdolmen.course.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Tag {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name = "jnd_tweet_tag",
	joinColumns = @JoinColumn(name = "tag_fk"),
	inverseJoinColumns = @JoinColumn(name = "tweet_fk"))
	private List<Tweet> tweets;

	public Tag(String name, Tweet... tweets) {
		this.name = name;
		this.tweets = new ArrayList<Tweet>();
		for(int i = 0; i < tweets.length; i++) {
			this.tweets.add(tweets[i]);
			tweets[i].addTag(this);
		}
	}
	
	public Tag(String name) {
		this.name = name;
		this.tweets = new ArrayList<Tweet>();
	}
	
	protected Tag() {		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addTweet(Tweet tweet) {
		this.tweets.add(tweet);
	}
	
	
}
