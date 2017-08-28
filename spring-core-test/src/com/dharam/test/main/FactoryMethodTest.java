package com.dharam.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dharam.test.domain.ICar;

public class FactoryMethodTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resource/static-factory-beans.xml");
		ICar car = (ICar)applicationContext.getBean("bus");
		car.drive();
	}

}
