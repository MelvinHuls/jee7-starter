package com.realdolmen.course.supplier;

import java.util.Arrays;
import java.util.List;

import com.realdolmen.course.annotation.Profane;

@Profane
public class ProfanityFortuneSupplier implements MessageSupplier{
	private List<String> messages = Arrays.asList(
			"Your fortune is terrible ... and you deserve it",
			"Surprise mofo, no happy day for you", 
			"You want to have good fortune with That face?",
			"Don't even try, shitty people get shitty fortune.",
			"You have shitty luck.",
			"Shit man, do you even want to live anymore? ... well, you might not want to very soon.");

	@Override
	public List<String> getMessages() {
		return this.messages;
	}
}
