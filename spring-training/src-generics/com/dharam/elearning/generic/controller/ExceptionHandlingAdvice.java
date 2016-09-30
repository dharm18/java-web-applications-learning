package com.dharam.elearning.generic.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controller Advice to all controllers
 * Exception handling controller
 * Applicable to controllers
 * @author Dharmendra
 *
 */
@ControllerAdvice
public class ExceptionHandlingAdvice {

	@ExceptionHandler
	public String handleDefault(Exception e) {
		return "error/error";
	}
	
}
