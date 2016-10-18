package com.realdolmen.course.domain;

import javax.enterprise.event.Observes;

import com.realdolmen.course.annotation.ShitChecker;

public class EventService {
	public void shitDropped(@Observes @ShitChecker String shit) {
		System.out.println("Shit Happened");
	}
}
