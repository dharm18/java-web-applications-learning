package com.dharam.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dharam.test.domain.StaticCar;

public class StaticDITest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resource/static-di-beans.xml");
		StaticCar car = (StaticCar)applicationContext.getBean("car");
		car.print();
	}
	
}
