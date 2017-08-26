package com.dharam.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArrayDIMain {

	
	public static void main(String[] args) {
		
		ApplicationContext ap = new ClassPathXmlApplicationContext("resource/beans.xml");
		System.out.println(ap.getBean("car"));
	}
}
