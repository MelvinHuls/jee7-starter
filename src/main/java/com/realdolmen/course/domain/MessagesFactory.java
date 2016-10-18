package com.realdolmen.course.domain;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.Produces;

import com.realdolmen.course.annotation.Prude;

public class MessagesFactory {
	@Produces
	@Prude
	public List<String> createSomeMessages() {
		return Arrays.asList(
				"Hello", 
				"Have a nice day", 
				"Something good will happen to you this week");
	}
}
