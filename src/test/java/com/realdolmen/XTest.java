package com.realdolmen;
import org.junit.Test;

import com.realdolmen.course.domain.Calc;
import com.realdolmen.course.domain.X;
import com.realdolmen.course.service.PersonServiceBean;

import static org.junit.Assert.*;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class XTest {
	@Test
	public void testIncreasingAge() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		X x = container.instance().select(X.class).get();
		x.setAge(15);
		x.increaseAge();
		//PersonServiceBean psb = container.instance().select(PersonServiceBean.class).get();
		assertEquals(16, x.getAge());
	}
	
}
