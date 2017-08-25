package com.dharam.test.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.dharam.test.domain.Employee;

public class Main {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		Employee emp1 = (Employee)factory.getBean("employee");
		Employee emp2 = (Employee)factory.getBean("employee");
		Employee emp3 = (Employee)factory.getBean("employee");
		
		System.out.println(emp1);
		System.out.println(emp1 == emp2);
		System.out.println(emp2 == emp3);
		
		
	}

}
