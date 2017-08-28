package com.dharam.test.main;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dharam.test.domain.SingletonTest;

public class FactoryMethodDITest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resource/static-factory-beans.xml");
		Calendar c = (Calendar)applicationContext.getBean("calendar");
		SingletonTest si = (SingletonTest)applicationContext.getBean("s");
		System.out.println(c);
	}

}
