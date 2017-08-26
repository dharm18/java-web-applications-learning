package com.dharam.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiringTypeTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("resource/autowire-types-beans.xml");
		System.out.println(context.getBean("car"));

	}

}
