package com.realdolmen.course.domain;

import javax.inject.Inject;


public class X {
	private int age;
	@Inject
	private Calc calc;
	
	public void increaseAge() {
		age = calc.add(1,age);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Calc getCalc() {
		return calc;
	}

	public void setCalc(Calc calc) {
		this.calc = calc;
	}
}
