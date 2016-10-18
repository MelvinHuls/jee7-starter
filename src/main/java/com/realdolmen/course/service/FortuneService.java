package com.realdolmen.course.service;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import com.realdolmen.course.annotation.ConfigMessage;
import com.realdolmen.course.annotation.GoodFortune;
import com.realdolmen.course.annotation.Profane;
import com.realdolmen.course.annotation.RegularMess;
import com.realdolmen.course.annotation.ShitChecker;
import com.realdolmen.course.supplier.MessageSupplier;

@Named("myFortuneService")
public class FortuneService {
	//@ConfigMessage
	@Profane
	//@RegularMess
	//@GoodFortune
	@Inject
	protected MessageSupplier supplier;
	
	@Inject
	@ShitChecker
	private Event<String> shitDroppedEvent;
	
	
	public String fortune() {
			String message = supplier.supplyRandomMessage();
			if(message.toLowerCase().contains("shit")) {
				shitDroppedEvent.fire(message);
			}
			return message;
	}
}
