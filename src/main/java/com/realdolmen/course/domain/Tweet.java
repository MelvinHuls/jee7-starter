package com.realdolmen.course.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.realdolmen.course.annotation.AntiProfanity;
import com.realdolmen.course.enums.STATUS;

@Entity
public class Tweet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*@Size(min=2) 
	private String username;*/
	
	@ManyToOne
	@JoinColumn(name = "user_fk")
	private Person user;
	
	//@Past 
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Size(max=140) 
	@AntiProfanity 
	private String message;	
	
	@ManyToMany(mappedBy = "tweets")
	private List<Tag> tags;
	

	@Enumerated(EnumType.STRING) 
	private STATUS status;
	
	
	/*
	 * used by JPA.
	 */
	protected Tweet() {		
	}
	
	Tweet(Person user, String message, Tag... tags) {
		this.user = user;
		this.message = message;
		this.date = new Date();
		
		//this.tags = new TreeSet<>(Arrays.asList(tags));
		this.tags = new ArrayList<Tag>();
		
		for(int i = 0; i < tags.length; i++) {
			this.tags.add(tags[i]);
			tags[i].addTweet(this);
		}
		
		this.status = STATUS.INACTIVE;
	}

	public Long getId() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}
	
	public void addTag(Tag tag) {
		this.tags.add(tag);
	}
	
	
}
