package com.dharam.elearning.user.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dharam.elearning.user.bean.User;

@Component
public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","required.name", "Name is required.");
		ValidationUtils.rejectIfEmpty(errors, "code","required.code", "Code is required.");
		ValidationUtils.rejectIfEmpty(errors, "description","required.description", "Description is required.");
		
	}

}
