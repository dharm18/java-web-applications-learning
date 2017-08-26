package com.dharam.test.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SetterDependencyInjection {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		System.out.println(factory.getBean("employee"));
		
	}

}
