package com.dharam.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionsDITest {

	public static void main(String[] args) {

		//ApplicationContext ap = new ClassPathXmlApplicationContext("resource/collections-beans.xml");
		ApplicationContext ap = new ClassPathXmlApplicationContext("resource/reqdcollections-beans.xml");
		System.out.println(ap.getBean("t"));
	}

}
