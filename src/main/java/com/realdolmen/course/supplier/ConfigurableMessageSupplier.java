package com.realdolmen.course.supplier;

import java.util.List;

import javax.inject.Inject;

import com.realdolmen.course.annotation.ConfigMessage;
import com.realdolmen.course.annotation.Prude;

@ConfigMessage
public class ConfigurableMessageSupplier  implements MessageSupplier{
	private List<String> messages;

	
	@Inject
	public ConfigurableMessageSupplier(
			@Prude List<String> messages) {
		this.messages = messages;
	}
	
	@Override
	public List<String> getMessages() {
		return this.messages;
	}
}
