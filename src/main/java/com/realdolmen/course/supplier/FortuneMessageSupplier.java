package com.realdolmen.course.supplier;

import java.util.Arrays;
import java.util.List;

import com.realdolmen.course.annotation.GoodFortune;

@GoodFortune
public class FortuneMessageSupplier implements MessageSupplier{
	private List<String> messages = Arrays.asList(
			"If you stand open for new posabilities you will broad your horizon",
			"Good fortune! Don't spend it too fast",
			"You will find what you are searching for nearby.",
			"Patience is the road to losing time");
	
	

	@Override
	public List<String> getMessages() {
		return this.messages;
	}	
}
