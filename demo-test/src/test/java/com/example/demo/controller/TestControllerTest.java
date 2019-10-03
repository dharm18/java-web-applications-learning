package com.example.demo.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.controller.TestController;

public class TestControllerTest {

	TestController testcontroller = new TestController();
	
	@Test
	public void testGreetMessage() {
		
		String expected = testcontroller.greetingMessage("Dharmendra");
		assertEquals(expected, "Hello Dharmendra");
	}
	
	@Test
	public void testEmptyNameGreetMessage() {
		
		String expected = testcontroller.greetingMessage(null);
		assertNotEquals(expected, "Hello Dharmendra");
	}

}
