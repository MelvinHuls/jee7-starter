package com.realdolmen.course.supplier;

import java.util.Arrays;
import java.util.List;

import com.realdolmen.course.annotation.RegularMess;

@RegularMess
public class RegularMessageSupplier implements MessageSupplier{
	private List<String> messages = Arrays.asList(
			"Message",
			"Hi", 
			"Hoi",
			"Testing");

	@Override
	public List<String> getMessages() {
		return this.messages;
	}
}
