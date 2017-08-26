package com.dharam.test.domain;

public class StaticCar {

	private static String name;

	public static void setName(String name) {
		StaticCar.name = name;
	}
	
	public void print(){
		System.out.println("Car : = " + name);
	}
	
	
}
