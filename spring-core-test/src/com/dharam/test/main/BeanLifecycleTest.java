package com.dharam.test.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("resource/lifecycle-beans.xml");
		applicationContext.getBean("course");
		applicationContext.close();
	}

}
