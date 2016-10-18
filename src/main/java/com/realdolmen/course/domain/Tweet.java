package com.realdolmen.course.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.realdolmen.course.annotation.AntiProfanity;

public class Tweet {
	@Size(min=2) private String username;
	@Past private Date date;
	@Size(max=140) @AntiProfanity private String message;	
	private Set<String> tags;
	
	Tweet(String username, String message, String... tags) {
		this.username = username;
		this.message = message;
		this.date = new Date();
		
		this.tags = new TreeSet<>(Arrays.asList(tags));
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
}
