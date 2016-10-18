package com.realdolmen.course.supplier;

import java.util.List;
import java.util.Random;

public interface MessageSupplier {
	public List<String> getMessages();
	
	public default String supplyRandomMessage () {
		//return getMessages().get((int)Math.random() * getMessages().size());		
		Random random = new Random();
		 int index = random.nextInt(getMessages().size());
		 return getMessages().get(index);
	}
}
