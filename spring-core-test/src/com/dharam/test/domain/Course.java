package com.dharam.test.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Course //implements InitializingBean,DisposableBean
{

	//@PostConstruct
	void init(){
		System.out.println("init COurse");
	}
	
	//@PreDestroy
	void destroy(){
		System.out.println("destroy COurse");
	}
	
	/*@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Destroy method");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("init COurse");
	}*/

}
