package com.realdolmen.course.service;

import static org.junit.Assert.assertNotNull;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FortuneServiceIntegrationTest {
	private WeldContainer container;

	@Before
	public void init() {
		Weld weld = new Weld();
		container = weld.initialize();		
	}
	
	/*
	 * optional depends on circumstances.
	 */
	@After
	public void destroy() {
		container.close();
	}
	
	@Test
	public void fortuneYieldsProfaneMessage() {
		FortuneService forserv = container.instance().select(FortuneService.class).get();
		String message = forserv.fortune();
		assertNotNull(message); //reasonable proof
		System.out.println(message);
	}
	
}
