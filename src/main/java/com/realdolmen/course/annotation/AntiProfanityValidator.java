package com.realdolmen.course.annotation;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AntiProfanityValidator  implements ConstraintValidator<AntiProfanity, String>{	
	@Override
	public void initialize(AntiProfanity constraintAnnotation) {
	}
	
	@Override
	public boolean isValid(String order, ConstraintValidatorContext context) {
		List<String> profaneWords = Arrays.asList(
				"shit",
				"dick",
				"trump",
				"fuck");
		Iterator<String> it = profaneWords.iterator();
		while(it.hasNext()) {
			if(order.toLowerCase().contains(it.next())) {
				return false;
			}
		}
		
		return true;
	}

}
