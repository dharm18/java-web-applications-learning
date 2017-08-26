package com.dharam.test.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class IOCContainerTest {

	public static void main(String[] args) {
	
		//loading core container
		
		/*Resource resource = new ClassPathResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		factory.getBean("employee");*/
		
		//loading application context container
		
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
		 	 context.getBean("employee");
		 	context.getBean("employee");
		 	context.getBean("employee");
		
		
	}
	
}
