package com.dharam.test.domain;

public class SingletonTest {

	private static SingletonTest instance;
	
	private SingletonTest(){
	}
	
	public static SingletonTest getInstance(){
		if(instance == null){
			instance = new SingletonTest();
		}
		
		return instance;
	}
}
