package com.realdolmen.course.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;
import javax.validation.Constraint;
import javax.validation.Payload;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Constraint(validatedBy = AntiProfanityValidator.class)
public @interface AntiProfanity {
	String message() default "Now now, don't fucking swear you bitch.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
