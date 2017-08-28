package com.dharam.test.main;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryMethodDITest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resource/static-factory-beans.xml");
		Calendar c = (Calendar)applicationContext.getBean("calendar");
		System.out.println(c);
	}

}
