package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	private static final String GREET_PREFIX = "Hello ";
	
	@RequestMapping("/greet")
	public String greetingMessage(@RequestParam String name) {
		return GREET_PREFIX + name;
	}

}
